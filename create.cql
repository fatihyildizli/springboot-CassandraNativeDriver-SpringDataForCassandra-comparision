CREATE KEYSPACE local WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '4'}  AND
durable_writes = true;

USE local;

create table local.dummy
(
	id bigint primary key,
	column_1 text,
	column_2 text
)
with caching = {'keys': 'ALL', 'rows_per_partition': 'NONE'}
	and compaction = {'max_threshold': '32', 'min_threshold': '4', 'class': 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy'}
	and compression = {'class': 'org.apache.cassandra.io.compress.LZ4Compressor', 'chunk_length_in_kb': '64'}
	and dclocal_read_repair_chance = 0.1;


