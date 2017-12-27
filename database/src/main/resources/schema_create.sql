drop table AdviseTest.dbo.chart;

create table AdviseTest.dbo.chart (
  symbol				varchar(10) not null,
  datee				date not null,
  openn				decimal(13,4),
  high				decimal(13,4),
  low					decimal(13,4),
  cloze				decimal(13,4),
  volume				bigint,
  unadjustedVolume	bigint,
  changee				decimal(15,6),
  changePercent		decimal(13,3),
  vwap				decimal(13,6),
  label				varchar(25),
  changeOverTime		float,

  constraint PK_chart primary key clustered (symbol, datee)
);

alter table AdviseTest.dbo.chart with check
  add constraint FK_chart_symbol
  foreign key (symbol) references symbol;

alter table AdviseTest.dbo.chart check constraint FK_chart_symbol;