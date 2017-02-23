CREATE TABLE IF NOT EXISTS greetings (
    tagid int,
    timestamps timestamp,
    value float,PRIMARY KEY (tagid,timestamps)
);

insert into greetings(tagid, timestamps,value) values(101,'2017-02-23 17:58:21',1000.24);

SELECT * FROM energytimedata WHERE tagid in(103,101) and timestamps <='2017-02-14 14:05:00';