# ShardingSphereBenchmarkTest

ShardingSphereDataSource 와 HikariDataSource 를 비교했다.

## 1. 변인

| 변인 | 내용 |
|---|---|
|독립|DataSource|
|종속|Benchmark (ms/op)|
|통제|SQL select all, select with sharding key, insert|

통제되지 않는 변인들
- 네트워크
  네트워크를 통해 DB 와 연결하는 과정에서 네트워크 상태에 따라 시간 차이가 생길 수 있다.
- DB
  날린 쿼리에 대해서 DB 상태에 따라 시간 차이가 생길 수 있다.
- Data
  현재 DB 에 있는 데이터 양에 따라서 시간 차이가 생길 수 있다.
- JVM, 컴퓨터 시스템
  Benchmark Test 가 돌아가는 JVM, 컴퓨터 시스템에 따라 시간 차이가 생길 수 있다.


## 2. 가설

데이터 양에 따른 성능
- 데이터가 적을 때, ShardingSpehre 가 더 느리다.
- 데이터가 적을 때, Sharding Key 를 활용하는 경우 비슷한 성능을 보일 것이다.
- 데이터가 많을 때, ShardingSphere 가 더 빠르다.

## 3. 결과

0920

ShardingSphereBenchmarkTest.insertComparison        avgt|5|25.210|1.220 ms/op
ShardingSphereBenchmarkTest.selectAllComparison     avgt|25|88.249|3.484 ms/op
ShardingSphereBenchmarkTest.selectAllShardingSPhere avgt|25|171.598|9.893 ms/op
ShardingSphereBenchmarkTest.selectComparison        avgt|25|83.126|4.352 ms/op
ShardingSphereBenchmarkTest.selectShardingSphere    avgt|25|87.311|5.644 ms/op

0921

ShardingSphereBenchmarkTest.insertComparison        avgt|5|26.849|10.057 ms/op
ShardingSphereBenchmarkTest.selectAllComparison     avgt|25|135.740|9.109 ms/op
ShardingSphereBenchmarkTest.selectAllShardingSPhere avgt|25|219.417|4.753 ms/op
ShardingSphereBenchmarkTest.selectComparison        avgt|25|128.846|5.227 ms/op
ShardingSphereBenchmarkTest.selectShardingSphere    avgt|25|138.052|44.346 ms/op

