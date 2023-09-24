## 24/09/23
### ABC083B - Some Sums
- 再帰関数における、値の保持
  - NG: 変数を下記のように定義すると、再帰する度に変数がリセットされる（下記例においては way = 0）。 retrurn way において必ず、way = 0である。
    ```python
    def sum_each_digits(arg: int) -> int:
      way:int = 0
      if arg < 1:
          return way
      number_of_digits: int = 10 ** (len(str(arg)) - 1)
      before_way: int = int(arg // number_of_digits)
      way += int(arg // number_of_digits)
      return sum_each_digits(arg % number_of_digits)
    ```  

  - OK: 
