###### Apache Cassandra | Spring Data for Cassandra - Cassandra Native Driver CRUD Performance Comparison

**✅ My Purpose**

In this POC project, I will compare the performance of two different drivers in rest architecture on spring boot as
 Spring Data for Cassandra & Cassandra Native Driver. The behaviors of CRUD operations in REST API format were compared. This project was coded for proofing of concept without any high level architecture or any software pattern. The main goal is to compare the performance of the two drivers for 1M transaction loop. **_`This article contains only informational results for local Cassandra Cluster. It may vary under different conditions`_**.


**Medium Link:** https://medium.com/@fatih_yildizli/apache-cassandra-spring-data-for-cassandra-cassandra-native-driver-crud-performance-comparison-97843e98e162

###### **‍🗨 Performance Ranking for CRUD 1 million row**

_**C**reate_

`Cassandra Native Driver      (19723ms) -
Spring Data for Cassandra    (3170808ms)`

_**R**ead_

`Cassandra Native Driver      (8668ms) - 
Spring Data for Cassandra    (50455ms)`

_**U**pdate_

`Cassandra Native Driver      (16691ms) - 
Spring Data for Cassandra    (3125532ms)`

_**D**elete_

`Cassandra Native Driver      (30055ms) - 
Spring Data for Cassandra    (3093708ms)`
