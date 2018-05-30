create table book
(
bookseq number(10) primary key,
bookfile varchar2(1000) not null,
booktitle varchar2(100) ,
bookauthor varchar2(100) ,
bookprice number(10,2),
booktag varchar2(500),
booktime date
);