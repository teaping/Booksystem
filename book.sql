USE [master]
GO
/****** Object:  Database [library]    Script Date: 2021-03-22 11:20:50 ******/
CREATE DATABASE [library]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'library', FILENAME = N'D:\S1项目资料\图书管理系统\数据库\library.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'library_log', FILENAME = N'D:\S1项目资料\图书管理系统\数据库\library_log.ldf' , SIZE = 3136KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [library] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [library].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [library] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [library] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [library] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [library] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [library] SET ARITHABORT OFF 
GO
ALTER DATABASE [library] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [library] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [library] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [library] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [library] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [library] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [library] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [library] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [library] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [library] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [library] SET  DISABLE_BROKER 
GO
ALTER DATABASE [library] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [library] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [library] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [library] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [library] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [library] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [library] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [library] SET RECOVERY FULL 
GO
ALTER DATABASE [library] SET  MULTI_USER 
GO
ALTER DATABASE [library] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [library] SET DB_CHAINING OFF 
GO
ALTER DATABASE [library] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [library] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [library]
GO
/****** Object:  Table [dbo].[libraryBookInfo]    Script Date: 2021-03-22 11:20:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING OFF
GO
CREATE TABLE [dbo].[libraryBookInfo](
	[bookcode] [varchar](20) NOT NULL,
	[bookname] [varchar](50) NOT NULL,
	[bookpublish] [varchar](50) NOT NULL,
	[bookaddnumber] [int] NOT NULL,
	[booksort] [varchar](20) NOT NULL,
	[bookauthor] [varchar](50) NOT NULL,
	[bookprice] [money] NOT NULL,
	[booktime] [datetime] NOT NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[libraryborrow]    Script Date: 2021-03-22 11:20:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING OFF
GO
CREATE TABLE [dbo].[libraryborrow](
	[readerid] [int] NULL,
	[bookcode] [varchar](20) NULL,
	[borrowdate] [datetime] NULL,
	[returndate] [datetime] NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[libraryManage]    Script Date: 2021-03-22 11:20:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING OFF
GO
CREATE TABLE [dbo].[libraryManage](
	[userid] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](50) NOT NULL,
	[uservalidate] [varchar](50) NOT NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[libraryreader]    Script Date: 2021-03-22 11:20:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING OFF
GO
CREATE TABLE [dbo].[libraryreader](
	[readerid] [int] IDENTITY(1,1) NOT FOR REPLICATION NOT NULL,
	[readername] [varchar](50) NOT NULL,
	[readercardid] [varchar](50) NOT NULL,
	[readerdate] [datetime] NOT NULL,
	[readertel] [varchar](50) NOT NULL,
	[readeraddress] [varchar](50) NOT NULL,
	[readerremark] [varchar](50) NOT NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[libraryUser]    Script Date: 2021-03-22 11:20:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[libraryUser](
	[userid] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](255) NULL,
	[userpassword] [varchar](255) NULL,
	[usertel] [varchar](255) NULL,
	[useraddress] [varchar](255) NULL,
	[userdate] [datetime] NULL,
	[userpurview] [varchar](255) NULL,
	[usertruce] [varchar](255) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[libraryBookInfo] ([bookcode], [bookname], [bookpublish], [bookaddnumber], [booksort], [bookauthor], [bookprice], [booktime]) VALUES (N'N20080808', N'java之父', N'北京大学出版社', 62, N'文学', N'崔剑', 88.8000, CAST(0x00009E6C00000000 AS DateTime))
INSERT [dbo].[libraryBookInfo] ([bookcode], [bookname], [bookpublish], [bookaddnumber], [booksort], [bookauthor], [bookprice], [booktime]) VALUES (N'N20080908', N'人体营养手册', N'陕西人民出版社', 77, N'美食', N'博特里', 12.0000, CAST(0x00009BC300000000 AS DateTime))
INSERT [dbo].[libraryBookInfo] ([bookcode], [bookname], [bookpublish], [bookaddnumber], [booksort], [bookauthor], [bookprice], [booktime]) VALUES (N'N2009006', N'人性的弱点', N'当代世界出版社', 66, N'修养', N'卡耐基', 28.0000, CAST(0x00009BD700000000 AS DateTime))
INSERT [dbo].[libraryBookInfo] ([bookcode], [bookname], [bookpublish], [bookaddnumber], [booksort], [bookauthor], [bookprice], [booktime]) VALUES (N'N20090109', N'余光中经典作品', N'湖南大学出版社', 11, N'文学', N'余光中', 80.0000, CAST(0x00009BC300000000 AS DateTime))
INSERT [dbo].[libraryBookInfo] ([bookcode], [bookname], [bookpublish], [bookaddnumber], [booksort], [bookauthor], [bookprice], [booktime]) VALUES (N'N20090208', N'毛泽东传', N'人民大学出版社', 40, N'传记', N'特里尔', 20.0000, CAST(0x00009BDE00000000 AS DateTime))
INSERT [dbo].[libraryBookInfo] ([bookcode], [bookname], [bookpublish], [bookaddnumber], [booksort], [bookauthor], [bookprice], [booktime]) VALUES (N'N20090706', N'首先，打破一切管理', N'当代世界出版社', 32, N'修养', N'马库斯', 23.0000, CAST(0x00009BC300000000 AS DateTime))
INSERT [dbo].[libraryBookInfo] ([bookcode], [bookname], [bookpublish], [bookaddnumber], [booksort], [bookauthor], [bookprice], [booktime]) VALUES (N'N20090801', N'舒婷的诗', N'北京大学出版社', 18, N'文学', N'舒婷', 88.6000, CAST(0x00009BC101837B06 AS DateTime))
INSERT [dbo].[libraryBookInfo] ([bookcode], [bookname], [bookpublish], [bookaddnumber], [booksort], [bookauthor], [bookprice], [booktime]) VALUES (N'N20090807', N'或隐忍着', N'人民大学出版社', 45, N'动漫', N'岸边', 67.0000, CAST(0x00009BC800000000 AS DateTime))
INSERT [dbo].[libraryBookInfo] ([bookcode], [bookname], [bookpublish], [bookaddnumber], [booksort], [bookauthor], [bookprice], [booktime]) VALUES (N'N20090808', N'水是最好的药', N'陕西人民出版社', 55, N'美食', N'马贴漫', 56.0000, CAST(0x00009BC300000000 AS DateTime))
INSERT [dbo].[libraryBookInfo] ([bookcode], [bookname], [bookpublish], [bookaddnumber], [booksort], [bookauthor], [bookprice], [booktime]) VALUES (N'N20090903', N'繁星春水', N'当代世界出版社', 8, N'文学', N'冰心', 30.0000, CAST(0x00009BD900000000 AS DateTime))
INSERT [dbo].[libraryBookInfo] ([bookcode], [bookname], [bookpublish], [bookaddnumber], [booksort], [bookauthor], [bookprice], [booktime]) VALUES (N'N20090908', N'思路决定出路', N'人民大学出版社', 45, N'修养', N'宿春礼', 25.7000, CAST(0x00009BC300000000 AS DateTime))
INSERT [dbo].[libraryBookInfo] ([bookcode], [bookname], [bookpublish], [bookaddnumber], [booksort], [bookauthor], [bookprice], [booktime]) VALUES (N'N23949382', N'美国军事', N'当代世界出版社', 29, N'政治 军事', N'安泰尔', 30.0000, CAST(0x00009BC500000000 AS DateTime))
INSERT [dbo].[libraryBookInfo] ([bookcode], [bookname], [bookpublish], [bookaddnumber], [booksort], [bookauthor], [bookprice], [booktime]) VALUES (N'N347465', N'thinking in java', N'湖南大学出版社', 22, N'文学', N'jack', 56.0000, CAST(0x00009BDF00000000 AS DateTime))
INSERT [dbo].[libraryBookInfo] ([bookcode], [bookname], [bookpublish], [bookaddnumber], [booksort], [bookauthor], [bookprice], [booktime]) VALUES (N'N47589459', N'天生地设', N'当代世界出版社', 44, N'求职', N'大将军', 80.0000, CAST(0x00009BCB00000000 AS DateTime))
INSERT [dbo].[libraryBookInfo] ([bookcode], [bookname], [bookpublish], [bookaddnumber], [booksort], [bookauthor], [bookprice], [booktime]) VALUES (N'N56783567', N'java世界', N'湖南大学出版社', 66, N'文学', N'崔剑', 88.0000, CAST(0x00009BD700000000 AS DateTime))
INSERT [dbo].[libraryBookInfo] ([bookcode], [bookname], [bookpublish], [bookaddnumber], [booksort], [bookauthor], [bookprice], [booktime]) VALUES (N'N65468376', N'火影忍者', N'上海大学出版社', 25, N'动漫', N'岸本齐史', 23.0000, CAST(0x00009BCA00000000 AS DateTime))
INSERT [dbo].[libraryBookInfo] ([bookcode], [bookname], [bookpublish], [bookaddnumber], [booksort], [bookauthor], [bookprice], [booktime]) VALUES (N'N76238437', N'傲视群雄', N'陕西人民出版社', 31, N'武侠', N'杜可风', 34.0000, CAST(0x00009BCE00000000 AS DateTime))
INSERT [dbo].[libraryBookInfo] ([bookcode], [bookname], [bookpublish], [bookaddnumber], [booksort], [bookauthor], [bookprice], [booktime]) VALUES (N'N78362098', N'金庸之王', N'人民大学出版社', 29, N'武侠', N'金庸', 78.0000, CAST(0x00009BC500000000 AS DateTime))
INSERT [dbo].[libraryBookInfo] ([bookcode], [bookname], [bookpublish], [bookaddnumber], [booksort], [bookauthor], [bookprice], [booktime]) VALUES (N'N88209890', N'java思想编程', N'北京大学出版社', 20, N'文学', N'崔剑', 34.0000, CAST(0x00009BCA00000000 AS DateTime))
INSERT [dbo].[libraryBookInfo] ([bookcode], [bookname], [bookpublish], [bookaddnumber], [booksort], [bookauthor], [bookprice], [booktime]) VALUES (N'N88209890', N'撒旦', N'北京大学出版社', 91, N'文学', N'卢', 88.0000, CAST(0x00009FCB00000000 AS DateTime))
INSERT [dbo].[libraryBookInfo] ([bookcode], [bookname], [bookpublish], [bookaddnumber], [booksort], [bookauthor], [bookprice], [booktime]) VALUES (N'N2232123', N'大十', N'北京大学出版社', 11, N'文学', N'路嘲', 12.0000, CAST(0x0000000000000000 AS DateTime))
INSERT [dbo].[libraryBookInfo] ([bookcode], [bookname], [bookpublish], [bookaddnumber], [booksort], [bookauthor], [bookprice], [booktime]) VALUES (N'N2232123', N'大十', N'北京大学出版社', 11, N'文学', N'路嘲', 12.0000, CAST(0x0000000000000000 AS DateTime))
INSERT [dbo].[libraryBookInfo] ([bookcode], [bookname], [bookpublish], [bookaddnumber], [booksort], [bookauthor], [bookprice], [booktime]) VALUES (N'N20081212', N'请问请问', N'陕西人民出版社', 12, N'文学', N'请问', 12.0000, CAST(0x0000000000000000 AS DateTime))
INSERT [dbo].[libraryBookInfo] ([bookcode], [bookname], [bookpublish], [bookaddnumber], [booksort], [bookauthor], [bookprice], [booktime]) VALUES (N'N0912312', N'ewqe', N'北京大学出版社', 12, N'文学', N'as', 12.0000, CAST(0x0000000000000000 AS DateTime))
INSERT [dbo].[libraryBookInfo] ([bookcode], [bookname], [bookpublish], [bookaddnumber], [booksort], [bookauthor], [bookprice], [booktime]) VALUES (N'N01212312', N'我去饿', N'北京大学出版社', 12, N'美食', N'12', 12.0000, CAST(0x0000000000000000 AS DateTime))
INSERT [dbo].[libraryBookInfo] ([bookcode], [bookname], [bookpublish], [bookaddnumber], [booksort], [bookauthor], [bookprice], [booktime]) VALUES (N'N20201216', N'希望', N'北京大学出版社', 12, N'文学', N'夏克南', 12.0000, CAST(0x0000000000000000 AS DateTime))
INSERT [dbo].[libraryborrow] ([readerid], [bookcode], [borrowdate], [returndate]) VALUES (3, N'N65468376', CAST(0x0000AC9001361CAC AS DateTime), CAST(0x0000ACA10135F27C AS DateTime))
INSERT [dbo].[libraryborrow] ([readerid], [bookcode], [borrowdate], [returndate]) VALUES (8, N'N20090807', CAST(0x0000AC9101318548 AS DateTime), CAST(0x0000AC920131715C AS DateTime))
INSERT [dbo].[libraryborrow] ([readerid], [bookcode], [borrowdate], [returndate]) VALUES (8, N'N20080808', CAST(0x00009BD900000000 AS DateTime), CAST(0x00009BEB00000000 AS DateTime))
INSERT [dbo].[libraryborrow] ([readerid], [bookcode], [borrowdate], [returndate]) VALUES (9, N'N20080808', CAST(0x00009BA300000000 AS DateTime), CAST(0x00009BE000000000 AS DateTime))
INSERT [dbo].[libraryborrow] ([readerid], [bookcode], [borrowdate], [returndate]) VALUES (3, N'N78362098', CAST(0x0000AC91016A14F8 AS DateTime), CAST(0x0000AC920169F7AC AS DateTime))
INSERT [dbo].[libraryborrow] ([readerid], [bookcode], [borrowdate], [returndate]) VALUES (3, N'N76238437', CAST(0x0000AC9200ACB354 AS DateTime), CAST(0x0000ACA300AC85A0 AS DateTime))
SET IDENTITY_INSERT [dbo].[libraryManage] ON 

INSERT [dbo].[libraryManage] ([userid], [username], [uservalidate]) VALUES (15, N'admin', N'123')
SET IDENTITY_INSERT [dbo].[libraryManage] OFF
SET IDENTITY_INSERT [dbo].[libraryreader] ON 

INSERT [dbo].[libraryreader] ([readerid], [readername], [readercardid], [readerdate], [readertel], [readeraddress], [readerremark]) VALUES (3, N'欧万军', N'431126198901170039', CAST(0x00009BC400000000 AS DateTime), N'15116206615', N'湖南永州', N'交个朋友吧!')
INSERT [dbo].[libraryreader] ([readerid], [readername], [readercardid], [readerdate], [readertel], [readeraddress], [readerremark]) VALUES (4, N'罗欣', N'430223198907153227', CAST(0x0000000000000000 AS DateTime), N'15073364132', N'湖南株洲', N'书是好东西')
INSERT [dbo].[libraryreader] ([readerid], [readername], [readercardid], [readerdate], [readertel], [readeraddress], [readerremark]) VALUES (8, N'王五', N'789789578578967897', CAST(0x00009BD800000000 AS DateTime), N'12573453489', N'湖南地区', N'呵呵!
')
INSERT [dbo].[libraryreader] ([readerid], [readername], [readercardid], [readerdate], [readertel], [readeraddress], [readerremark]) VALUES (9, N'罗霞', N'827384298384932423', CAST(0x00009BD800000000 AS DateTime), N'12387268789', N'湖南株洲', N'哈哈！
')
INSERT [dbo].[libraryreader] ([readerid], [readername], [readercardid], [readerdate], [readertel], [readeraddress], [readerremark]) VALUES (10, N'张山', N'254646546353454353', CAST(0x0000A69100000000 AS DateTime), N'43535364564', N'ssd', N'未知世界更美好1')
INSERT [dbo].[libraryreader] ([readerid], [readername], [readercardid], [readerdate], [readertel], [readeraddress], [readerremark]) VALUES (23, N'李圣杰', N'435345245324535345', CAST(0x00009BD800000000 AS DateTime), N'34532453245', N'中国台湾', N'我的歌最好听了!')
INSERT [dbo].[libraryreader] ([readerid], [readername], [readercardid], [readerdate], [readertel], [readeraddress], [readerremark]) VALUES (24, N'卡卡西', N'789467456745674567', CAST(0x00009BD800000000 AS DateTime), N'12376576789', N'木叶忍者村', N'火的历练，无比神圣!')
INSERT [dbo].[libraryreader] ([readerid], [readername], [readercardid], [readerdate], [readertel], [readeraddress], [readerremark]) VALUES (25, N'佐助', N'237347324673256756', CAST(0x00009BD800000000 AS DateTime), N'67567567456', N'木叶村', N'家族，永远的恨!')
INSERT [dbo].[libraryreader] ([readerid], [readername], [readercardid], [readerdate], [readertel], [readeraddress], [readerremark]) VALUES (27, N'周永盛', N'463526374857463734', CAST(0x00009BD800000000 AS DateTime), N'13407313966', N'永州江永', N'时间时江')
INSERT [dbo].[libraryreader] ([readerid], [readername], [readercardid], [readerdate], [readertel], [readeraddress], [readerremark]) VALUES (130, N'123123', N'123123123', CAST(0x0000000000000000 AS DateTime), N'123', N'123', N'123')
SET IDENTITY_INSERT [dbo].[libraryreader] OFF
SET IDENTITY_INSERT [dbo].[libraryUser] ON 

INSERT [dbo].[libraryUser] ([userid], [username], [userpassword], [usertel], [useraddress], [userdate], [userpurview], [usertruce]) VALUES (61, N'admin', N'12', N'15116206615', N'湖南永州', CAST(0x00009BC600000000 AS DateTime), N'管理员', N'在线')
INSERT [dbo].[libraryUser] ([userid], [username], [userpassword], [usertel], [useraddress], [userdate], [userpurview], [usertruce]) VALUES (62, N'luoxin', N'123', N'15073364132', N'湖南株洲', CAST(0x00009BC500000000 AS DateTime), N'普通用户', N'下线')
INSERT [dbo].[libraryUser] ([userid], [username], [userpassword], [usertel], [useraddress], [userdate], [userpurview], [usertruce]) VALUES (74, N'罗欣', N'123', N'98797899898', N'湖南', CAST(0x00009BD800000000 AS DateTime), N'普通用户', N'下线')
INSERT [dbo].[libraryUser] ([userid], [username], [userpassword], [usertel], [useraddress], [userdate], [userpurview], [usertruce]) VALUES (76, N'欧万军', N'123', N'15116206615', N'湖南永州', CAST(0x00009BDF00000000 AS DateTime), N'普通用户', N'下线')
INSERT [dbo].[libraryUser] ([userid], [username], [userpassword], [usertel], [useraddress], [userdate], [userpurview], [usertruce]) VALUES (77, N'何源', N'123', N'18570351290', NULL, CAST(0x0000A68200C6E946 AS DateTime), N'', N'')
INSERT [dbo].[libraryUser] ([userid], [username], [userpassword], [usertel], [useraddress], [userdate], [userpurview], [usertruce]) VALUES (80, N'夏', N'123', N'123123', N'上海', CAST(0x0000000000000000 AS DateTime), N'管理员', N'下线')
INSERT [dbo].[libraryUser] ([userid], [username], [userpassword], [usertel], [useraddress], [userdate], [userpurview], [usertruce]) VALUES (1081, N'12', N'12', N'12', N'123', CAST(0x0000000000000000 AS DateTime), N'管理员', N'')
INSERT [dbo].[libraryUser] ([userid], [username], [userpassword], [usertel], [useraddress], [userdate], [userpurview], [usertruce]) VALUES (1083, N'we', N'123', N'12312', N'上海', CAST(0x0000000000000000 AS DateTime), N'普通用户', N'')
SET IDENTITY_INSERT [dbo].[libraryUser] OFF
USE [master]
GO
ALTER DATABASE [library] SET  READ_WRITE 
GO
