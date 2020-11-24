
-- 建库语句

CREATE DATABASE LMS
    ON PRIMARY (
    NAME = LMS,
    FILENAME = 'E:\lms\sql\LMS.mdf',
    SIZE = 3,
    FILEGROWTH = 1
    )
    LOG ON (
    NAME = LMS_log,
    FILENAME = 'E:\lms\sql\LMS_log.ldf',
    SIZE = 1,
    MAXSIZE = 20,
    FILEGROWTH = 10 %
    )

-- 建表语句

USE LMS

-- 书籍表
GO
CREATE TABLE Book (
                      BID int NOT NULL,
                      BNO VARCHAR(20) NOT NULL,
                      BNAME VARCHAR(50) NULL,
                      BAUTHOR VARCHAR(30) NULL,
                      BPUB VARCHAR(30) NULL,
                      BPRICE FLOAT NULL,
                      PRIMARY KEY (BID)
)
GO

-- 读者表
GO
CREATE TABLE Reader (
                        RNO int NOT NULL,
                        RNAME VARCHAR(8) NOT NULL,
                        password VARCHAR(50) NOT NULL, -- 用户密码
                        superUser int NOT NULL,     -- 超级用户 0 否 1 是
                        RSEX VARCHAR(2) NOT NULL,
                        RTEL VARCHAR(8) NULL,
                        RDEP VARCHAR(30) NULL,
                        PRIMARY KEY (RNO)
)
GO

-- 借阅表
GO
CREATE TABLE BR (
                    BID int NOT NULL,
                    RNO int NOT NULL,
                    BNO VARCHAR(20) NULL,
                    OUTDATE DATE NULL,
                    INDATE DATE NULL,
                    FOREIGN KEY (RNO) REFERENCES reader(RNO),
                    FOREIGN KEY (BID) REFERENCES book(BID)
)
GO


-- 插入语句

INSERT INTO Book VALUES (1,'TN913.2/530','电信网技术','马同名','人民邮电出版社',7.5)

INSERT INTO Book VALUES (2,'TP311.13/CM3','数据库原理','苗晨曦','清华大学出版社',28)

INSERT INTO Book VALUES (3,'TP311.132/ZG1','XML数据库设计与开发','尹相军','清华大学出版社',38)

INSERT INTO Book VALUES (4,'TP316/ZW6','操作系统原理','吴庆冰','科学出版社',35)

INSERT INTO Book VALUES (5,'TP316/ZY1','操作系统技术','沈言','电子工业出版社',31)

INSERT INTO Book VALUES (6,'TP391.132.3/ZG5','网络数据库技术','李睿智','清华大学出版社',45)

INSERT INTO Reader (RNO,RNAME,password,superUser,RSEX,RTEL)
VALUES (2073,'王平','123456',1,'男','66573249')

INSERT INTO Reader (RNO,RNAME,password,superUser,RSEX,RTEL)
VALUES (2074,'张力','123456',1,'女','66573249')

INSERT INTO Reader (RNO,RNAME,password,superUser,RSEX,RTEL)
VALUES (2075,'王辉煌','123456',1,'男','66573249')

INSERT INTO Reader (RNO,RNAME,password,superUser,RSEX,RTEL)
VALUES (2076,'李建','123456',1,'男','66573249')

INSERT INTO Reader (RNO,RNAME,password,superUser,RSEX,RTEL)
VALUES (2077,'程淡云','123456',1,'女','66573249')

INSERT INTO BR(BID,RNO,BNO,OUTDATE,INDATE) VALUES (2,2073,'TP311.132/ZG1','2009-1-27','2009-3-28')

INSERT INTO BR(BID,RNO,BNO,OUTDATE,INDATE) VALUES (4,2073,'TP316/ZW6','2009-1-27','2009-3-28')

INSERT INTO BR(BID,RNO,BNO,OUTDATE,INDATE) VALUES (3,2075,'TP311.132/ZG1','2009-1-27','2009-3-28')

INSERT INTO BR(BID,RNO,BNO,OUTDATE,INDATE) VALUES (2,2074,'TP311.13/CM3','2009-1-27','2009-3-28')

INSERT INTO BR(BID,RNO,BNO,OUTDATE,INDATE) VALUES (4,2075,'TP316/ZW6','2009-1-27','2009-3-28')

INSERT INTO BR(BID,RNO,BNO,OUTDATE,INDATE) VALUES (3,2074,'TP311.132/ZG1','2009-1-28','2009-3-28')
