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