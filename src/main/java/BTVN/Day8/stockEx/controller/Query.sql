create database StockExchange
go
use StockExchange;
create table TraderTable
(
    sIDTrader     nvarchar not null,
    TraderName    nvarchar not null,
    TraderAddress nvarchar,
    TraderFund    float    not null
)
go

create unique index TraderTable_sIDTrader_uindex
    on TraderTable (sIDTrader)
go

alter table TraderTable
    add constraint TraderTable_pk
        primary key nonclustered (sIDTrader)
go

create table StockTable
(
    sIDStock  nvarchar not null,
    StockName nvarchar not null,
    Company   nvarchar not null
)
go

create unique index StockTable_sIDStock_uindex
    on StockTable (sIDStock)
go

alter table StockTable
    add constraint StockTable_pk
        primary key nonclustered (sIDStock)
go

create table OrderTable
(
    sIDOrder  int identity,
    type      int
        check (type in (1, 2)),
    sIDStock  nvarchar not null
        constraint OrderTable___fk_Stock
            references StockTable,
    sIDTrader nvarchar not null
        constraint OrderTable___fk_Trader
            references TraderTable,
    amount    int      not null,
    price     float    not null
)
go

create unique index OrderTable_sIDOrder_uindex
    on OrderTable (sIDOrder)
go

alter table OrderTable
    add constraint OrderTable_pk
        primary key nonclustered (sIDOrder)
go

create table TransactionTable
(
    tranID   int identity,
    idStock  nvarchar not null
        constraint TransactionTable___fk_Stock
            references StockTable,
    idBuyer  nvarchar not null
        constraint TransactionTable___fk_Buyer
            references TraderTable,
    idSeller nvarchar not null
        constraint TransactionTable___fk_Seller
            references TraderTable,
    amount   int      not null,
    price    float    not null,
    date     date
)
go

create unique index TransactionTable_tranID_uindex
    on TransactionTable (tranID)
go

alter table TransactionTable
    add constraint TransactionTable_pk
        primary key nonclustered (tranID)
go

-- Tính tổng số tiền giao dịch
create procedure getAllTxMoney
as
begin
    select SUM(price * amount) Total from TransactionTable
end
go

-- Lấy ra danh sách cổ phiếu với tổng số tiền giao dịch tương ứng;
create procedure getTxByStocks
as
begin
    select idStock, SUM(price * amount) TotalMoney
    from TransactionTable
    group by idStock
    order by TotalMoney
end
go

--- Lấy danh sách cổ phiếu có số tiền giao dịch lớn nhất
create procedure getHighestPriceStock

as
    begin
        DECLARE @max float
        select @max = max(SubPrice)from
            (select idStock,sum(price*amount)SubPrice from TransactionTable
             group by idStock) SubTable

        select idStock,sum(price*amount) as Subtotal from TransactionTable
        group by idStock
        having (sum(price*amount)=@max)
    end
