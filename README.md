cpi-stats
=========

ロジスティクス回帰のアルゴリズムを実装してみた
推定対象の関数はsin関数を選んだ。0.0から1.0の範囲内で平均値0.0, 分散が0.2に従うガウスノイズを加えたものを10点用意。
それを訓練データとした。モデルは20次の多項式関数を使用。


## 最尤推定
グラフで青点が訓練データ。緑実践が推定モデル。
![LeastSquares_lambda](https://raw.github.com/PhysicsEngine/cpi-stats/master/results/LeastSquares_lambda.png)

## MAP推定
グラフで青点が訓練データ。緑実践が推定モデル。
![LeastSquares](https://raw.github.com/PhysicsEngine/cpi-stats/master/results/LeastSquares.png)

## ベイズ推定
ベイス推定においては緑実践が各点における平均値で、緑点線が1σに対応する範囲
![BayesEstimation](https://raw.github.com/PhysicsEngine/cpi-stats/master/results/BayesEstimation.png)

