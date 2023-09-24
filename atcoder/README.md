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
  
