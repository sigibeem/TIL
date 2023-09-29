## 29/09/23 本日より降順とする（最新の日付が先頭）
### A - 321-like Checker
### B - Cutoff

<details>
  <summary>binary searchでええやん、2分岐探索って言いづらくない？　</summary>

  - [過去問](https://atcoder.jp/contests/abc321/tasks)を実施、100分ではAは解けたが、Bは不正解、C以降は手を付けられなかった。
  - Bの回答においてbinary search（日本語だと、にぶんき、にほんきとかややこしい）が使われていた。
    知ってはいたが、どの様に使うかと言う知識が抜けていた or 使えるタイミングを知らないため頭の引き出しがひらかない
  - 今後使えるように流れと使用タイミングを下記する。
  
  [ 流れ ]
  1. 索敵範囲を定義する。　min, max = 0, 100
  2. max, minより中間値を定義。　median = int((max + min) // 2)
  3. 中間値 (median) と目的地 (target_value) との大小を比較
     3-1. 大きい場合 median > target_value -> maxを下げる
      max = median - 1 <- -1するのは最終的にl == rとしてloopを抜けるため
     3-2. 小さい場合　-> minを上げる
     min = median + 1
  4. min >= maxを条件としてloopを回す
  
  [ タイミング ]
  - forを回す際に基本的に使える？
  - ってきり、forって O(logn)？だから重い処理と...ちゃんと調べて正しい知識をつけようね！


</details>     

## 24/09/23
### ABC083B - Some Sums

<details>
  <summary>
再帰関数における、値の保持</summary>
  
  - NG: 変数を下記のように定義すると、再帰する度に変数がリセットされる（下記例においては way = 0）。 retrurn way において必ず、way = 0である。
    ```python
    
    def sum_each_digits(arg: int) -> int:
      way:int = 0
      if arg < 1:
          return way
      number_of_digits: int = 10 ** (len(str(arg)) - 1)
      way += int(arg // number_of_digits)
      return sum_each_digits(arg % number_of_digits)
    ```

  - OK: 引数に維持したい値を渡す
    ```python
    def sum_each_digits(arg: int, way: int=0) -> int:
    if arg < 1:
        return way
    number_of_digits: int = 10 ** (len(str(arg)) - 1)
    way += int(arg // number_of_digits)
    return sum_each_digits(arg % number_of_digits, way)
    ```
</details>

<details>
  <summary>型変換（int -> str -> int）による恩恵</summary>
  
  - strに型変換することで、スライス可能に -> 各桁毎に処理可能
  
  ```python
  
  int_arg: int = 21
  # int_arg[0] -> Error
  each_digits = list(map(int, str(int_arg))) #strに変換することでスライス可能 -> 各桁毎にint()
  # each_digits -> [2, 1], type(each_digits) -> int
  ```
</details>

### ABC088B	Card Game for Two
### ABC085B	Kagami Mochi

<details>
  <summary>twitter</summary>
  
  - 他の人の解答見たいのに500でerror返すのなんなん
  - pythonだと使用メモリが8000KB台が多い（自分もそうだし、他の提出でも）, Go, Rustは1000 ~ 2000KB台
  
</details>

## 25/09/23
### ABC085C - Otoshidama

<details>
  <summary>forではなく、関数で回す</summary>
  
<details>
  <summary>諦め</summary>
    
  - forで回しているコードを見ると、実行時間が5桁KBなので、関数で回したい
  - 5000 yenによる支払いが最初は不要と考えた。1000 yen * 5で補えると考えた。しかし、枚数を考えると必須。
  - 処理の流れを下記
    
    総計をY yen, もらったお金の総枚数を N とする
      1. Y - 10k * i for i in range(N)でループを回す、 i の増加共に N - i 
      2. まず、1.で Y - 10k * iで0か、N=0確認　: break ? by_10kを実行　←0の確認いるか？確認せずにby_10k, by_5kを回しても問題ないのでは？ 
      3. 
  
  ```python
  N, Y = 2000, 20000000 #map(int, input().split())

def by_1k(N:int, Y:int, result_list:list[int]) -> list[int]:
    result_list[2] = int(Y / 1000)
    return result_list if int(Y / 1000) == N else 0


def by_5k(_N:int, _Y:int, _result_list: list[int]) -> list[int]:
    for i in range(_N+1):
        Y:int = _Y - 5000*i
        N:int = _N - i
        if Y < 0:
            break
        # Yが5kの倍数であった場合
        if N == 0 and Y == 0:
            _result_list[1] = i 
            return _result_list
        elif by_1k(N, Y, _result_list):
            return i
        else:
            continue
    return 0


def by_10k(_N:int, _Y:int) -> list[int]:
    result: list[int] = [0, 0, 0]
    for i in range(_N+1):
        Y:int = _Y - 10000*i
        N:int = _N - i
        if Y < 0:
            break
        # Yが10kの倍数であった場合
        if N == 0 and Y == 0:
            result[0] = i
            return result
        elif by_1k(N, Y):
                result[0] = i
                result[2] = by_1k(N, Y)
                return result
        else:
            continue
    return [-1, -1, -1]

print(by_10k(N, Y))

# 10kを優先して引いていく, for文で0 ~ Nまですで回す
  ```
</details>  
</details>

## 290923

### A - 321-like Checker
### B - Cutoff

<details>
  <summary>考え方</summary>

  - 最後の値 Nx（Nラウンド目の値）によって、条件分岐しようとしていた。
  NG: 条件分岐する際の境界線である、N_min, N_maxが変動する可能性がある。→ Nx < N_min →　Nx is N_min, N_min is not N_min
  
  なぜ条件分岐する必要があったのか: わからない。
  
  # こういうことを防ぐためにも、コードの流れを明文化させておく必要がある。なぜこの処理が必要なのか等
  
  - Nxによって処理が異なると考えたから、分岐させようとした。
  上記考えがあまり良くない。そもそも分岐できない。境界線であるN_min, N_maxが未知であるため。なので、ここでは分岐しない。
</details>
