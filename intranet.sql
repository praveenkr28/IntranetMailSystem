-- phpMyAdmin SQL Dump
-- version 3.5.2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 07, 2012 at 05:36 PM
-- Server version: 5.5.25a
-- PHP Version: 5.4.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `intranet`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE IF NOT EXISTS `address` (
  `actname` varchar(50) NOT NULL,
  `uname` varchar(50) NOT NULL,
  `nickname` varchar(50) NOT NULL,
  `emailid` varchar(50) NOT NULL,
  `addresses` varchar(99) NOT NULL,
  `phone` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `address`
--

INSERT INTO `address` (`actname`, `uname`, `nickname`, `emailid`, `addresses`, `phone`) VALUES
('praveen', 'anshu', 'ad', '', '', 12),
('praveen', 'anshu', 'ankur', 'parveen@ghail.com', 'vg', 123),
('anshu', 'praveen', 'praveen', 'praveen', 'zxcv', 123),
('gopal', 's', 's', 'ss', 'ssss', 1215),
('gopal', 'hg', 'ggh', 'mh', 'hg', 12),
('gopal', 'gh', 'as', 'gfd', 'dsf', 1234);

-- --------------------------------------------------------

--
-- Table structure for table `folders`
--

CREATE TABLE IF NOT EXISTS `folders` (
  `uname` varchar(50) NOT NULL,
  `folder` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `folders`
--

INSERT INTO `folders` (`uname`, `folder`) VALUES
('anshu', 'Trash');

-- --------------------------------------------------------

--
-- Table structure for table `newcompose`
--

CREATE TABLE IF NOT EXISTS `newcompose` (
  `mailid` int(25) NOT NULL,
  `mailfrom` varchar(50) NOT NULL,
  `mailto` varchar(50) NOT NULL,
  `subject` varchar(80) NOT NULL,
  `mailcc` varchar(50) NOT NULL,
  `mailbcc` varchar(50) NOT NULL,
  `mailexch` varchar(50) NOT NULL,
  `maildata` varchar(99) NOT NULL,
  `folder` varchar(50) NOT NULL,
  `maildate` varchar(35) NOT NULL,
  `mailst` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `newcompose`
--

INSERT INTO `newcompose` (`mailid`, `mailfrom`, `mailto`, `subject`, `mailcc`, `mailbcc`, `mailexch`, `maildata`, `folder`, `maildate`, `mailst`) VALUES
(3, 'anshu', '', 'nothing', '', '', '', '', 'inbox', 'Fri Oct 26 11:56:11 IST 2012', 0),
(4, 'praveen', 'anshu', 'nothing', 'asd', 'zx', '', '', 'inbox', 'Fri Oct 26 12:18:03 IST 2012', 0),
(5, 'praveen', 'asd', 'nothing', '', 'zx', '', '', 'inbox', 'Fri Oct 26 12:18:03 IST 2012', 0),
(7, 'praveen', '', '', '', '', '', '', 'inbox', 'Sat Oct 27 17:05:36 IST 2012', 0),
(9, 'praveen', '', '', '', '', '', '', 'inbox', 'Sat Oct 27 17:08:54 IST 2012', 0),
(11, 'praveen', '', '', '', '', '', '', 'inbox', 'Sat Oct 27 17:15:21 IST 2012', 0),
(13, 'anshu', '', '', '', '', '', '', 'inbox', 'Sat Oct 27 17:27:48 IST 2012', 0),
(14, 'anshu', 'praveen', '', '', '', '', '', 'inbox', 'Sat Oct 27 17:33:07 IST 2012', 0),
(15, 'anshu', '', '', '', '', '', '', 'inbox', 'Sat Oct 27 17:33:07 IST 2012', 0),
(17, 'praveen', '', '', '', '', '', '', 'inbox', 'Sat Oct 27 18:31:30 IST 2012', 0),
(18, 'praveen', 'anshu', 'adad', '', '', '', '', 'inbox', 'Sun Oct 28 19:27:40 IST 2012', 0),
(19, 'praveen', '', 'adad', '', '', '', '', 'inbox', 'Sun Oct 28 19:27:40 IST 2012', 0),
(1, 'praveen', '', '', '', '', '', '', 'inbox', 'Mon Oct 29 17:05:43 IST 2012', 0),
(20, 'praveen', 'anshu', '', '', '', '', '', 'inbox', 'Mon Oct 29 17:05:53 IST 2012', 0),
(21, 'praveen', '', '', '', '', '', '', 'inbox', 'Mon Oct 29 17:05:53 IST 2012', 0),
(22, 'praveen', 'anshu', '', '', '', '', '', 'inbox', 'Mon Oct 29 17:05:53 IST 2012', 0),
(23, 'praveen', '', '', '', '', '', '', 'inbox', 'Mon Oct 29 17:05:53 IST 2012', 0),
(24, 'praveen', 'anshu', '', '', '', '', '', 'inbox', 'Mon Oct 29 17:06:09 IST 2012', 0),
(25, 'praveen', '', '', '', '', '', '', 'inbox', 'Mon Oct 29 17:06:09 IST 2012', 0),
(26, 'praveen', 'anshu', 'nothing', '', '', '', '', 'inbox', 'Tue Oct 30 18:46:27 IST 2012', 0),
(27, 'praveen', '', 'nothing', '', '', '', '', 'inbox', 'Tue Oct 30 18:46:27 IST 2012', 0),
(28, 'anshu', 'praveen', 'add', '', '', '', '', 'inbox', 'Tue Oct 30 19:41:41 IST 2012', 0),
(29, 'anshu', '', 'add', '', '', '', '', 'inbox', 'Tue Oct 30 19:41:41 IST 2012', 0),
(30, 'praveen', '', '', '', '', '', '', 'inbox', 'Tue Oct 30 19:42:41 IST 2012', 0),
(31, 'praveen', 'anshu', 'acd', '', '', '', '', 'inbox', 'Tue Oct 30 20:34:28 IST 2012', 0),
(32, 'praveen', '', 'acd', '', '', '', '', 'inbox', 'Tue Oct 30 20:34:28 IST 2012', 0),
(33, 'anshu', 'praveen', '123', '', '', '', 'hello i am new ', 'inbox', 'Tue Oct 30 20:35:30 IST 2012', 0),
(34, 'anshu', '', '123', '', '', '', 'hello i am new ', 'inbox', 'Tue Oct 30 20:35:30 IST 2012', 0),
(35, 'gopal', 'anshu', 'abc', 'cc', 'bcc', '', 'vghbvgh', 'inbox', 'Mon Nov 05 22:23:54 PST 2012', 0),
(36, 'gopal', 'cc', 'abc', '', 'bcc', '', 'vghbvgh', 'inbox', 'Mon Nov 05 22:23:54 PST 2012', 0),
(38, 'anshu', '', 'null', '', '', '', 'hghg', 'inbox', 'Mon Nov 05 22:25:13 PST 2012', 0),
(1, 'gopal', '', 'dxc', '', '', '', 'dxvcxd', 'inbox', 'Tue Nov 06 21:51:45 PST 2012', 0),
(39, 'gopal', 'anshu', 'hj', '', '', '', 'jhjkhjknh', 'inbox', 'Tue Nov 06 22:13:00 PST 2012', 0),
(40, 'gopal', '', 'hj', '', '', '', 'jhjkhjknh', 'inbox', 'Tue Nov 06 22:13:00 PST 2012', 0),
(41, 'gopal', 'anshu', 'hgh', '', '', '', 'fygg hhg', 'inbox', 'Tue Nov 06 22:22:00 PST 2012', 0),
(42, 'gopal', 'anshu', 'jkl', '', '', '', 'edrduftu', 'inbox', 'Tue Nov 06 22:27:04 PST 2012', 0),
(43, 'gopal', 'anshu', 'fgfg', '', '', '', 'fbfdbf', 'inbox', 'Tue Nov 06 22:36:10 PST 2012', 0),
(44, 'gopal', 'anshu', 'fgfg', '', '', '', 'fbfdbf', 'inbox', 'Tue Nov 06 22:36:56 PST 2012', 0),
(45, 'gopal', 'anshu', 'hrtftds', 'rsdg', 'srg', '', 'grfgr', 'inbox', 'Tue Nov 06 22:43:08 PST 2012', 0),
(46, 'gopal', 'anshu', '', '', '', '', '', 'inbox', 'Tue Nov 06 22:45:04 PST 2012', 0),
(47, 'gopal', 'anshu', '', '', '', '', '', 'inbox', 'Tue Nov 06 22:47:29 PST 2012', 0),
(48, 'gopal', 'anshu', '', '', '', '', '', 'inbox', 'Tue Nov 06 22:48:45 PST 2012', 0),
(49, 'gopal', 'anshu', '', '', '', '', '', 'inbox', 'Tue Nov 06 22:50:30 PST 2012', 0),
(50, 'gopal', 'anshu', '', '', '', '', '', 'inbox', 'Tue Nov 06 22:52:41 PST 2012', 0),
(51, 'gopal', 'anshu', '', '', '', '', '', 'inbox', 'Tue Nov 06 22:55:01 PST 2012', 0),
(52, 'gopal', 'anshu', '', '', '', '', '', 'inbox', 'Tue Nov 06 22:57:47 PST 2012', 0),
(53, 'gopal', 'anshu', '', '', '', '', '', 'inbox', 'Tue Nov 06 22:58:44 PST 2012', 0),
(54, 'gopal', '', '', '', '', '', '', 'inbox', 'Tue Nov 06 22:58:44 PST 2012', 0),
(55, 'gopal', 'anshu', 'pro', 'mk', 'nj', '', 'anshu is', 'inbox', 'Tue Nov 06 23:00:52 PST 2012', 0),
(56, 'gopal', '', 'pro', 'mk', 'nj', '', 'anshu is', 'inbox', 'Tue Nov 06 23:00:52 PST 2012', 0),
(57, 'gopal', 'anshu', '', '', '', '', 'dhfh', 'inbox', 'Wed Nov 07 01:28:35 PST 2012', 0),
(58, 'gopal', '', '', '', '', '', 'dhfh', 'inbox', 'Wed Nov 07 01:28:35 PST 2012', 0),
(59, 'gopal', 'anshu', '11', '111', '', '', 'dscdsc', 'inbox', 'Wed Nov 07 01:39:15 PST 2012', 0),
(60, 'gopal', '111', '11', '', '', '', 'dscdsc', 'inbox', 'Wed Nov 07 01:39:15 PST 2012', 0),
(61, 'gopal', 'anshu', '', '', '', '', 'n', 'inbox', 'Wed Nov 07 02:29:46 PST 2012', 0),
(62, 'gopal', '', '', '', '', '', 'n', 'inbox', 'Wed Nov 07 02:29:46 PST 2012', 0),
(63, 'anshu', 'gopal', 'acd', '', '', '', 'ggjf', 'inbox', 'Wed Nov 07 08:29:35 PST 2012', 0),
(64, 'anshu', '', 'acd', '', '', '', 'ggjf', 'inbox', 'Wed Nov 07 08:29:35 PST 2012', 0),
(65, 'gopal', 'anshu', 'ds', '', '', '', 'cdsfcsdv', 'inbox', 'Wed Nov 07 08:33:58 PST 2012', 0),
(66, 'gopal', '', 'ds', '', '', '', 'cdsfcsdv', 'inbox', 'Wed Nov 07 08:33:58 PST 2012', 0);

-- --------------------------------------------------------

--
-- Table structure for table `newfolder`
--

CREATE TABLE IF NOT EXISTS `newfolder` (
  `mid` int(8) NOT NULL,
  `mfrom` varchar(40) NOT NULL,
  `mto` varchar(40) NOT NULL,
  `sub` varchar(40) NOT NULL,
  `mcc` varchar(40) NOT NULL,
  `mdata` longtext NOT NULL,
  `folder` int(15) NOT NULL,
  `mailst` int(4) NOT NULL,
  `maildate` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sentmail`
--

CREATE TABLE IF NOT EXISTS `sentmail` (
  `To` varchar(20) NOT NULL,
  `Sub` varchar(20) NOT NULL,
  `CC` varchar(20) NOT NULL,
  `Bcc` varchar(20) NOT NULL,
  `Message` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sentmail`
--

INSERT INTO `sentmail` (`To`, `Sub`, `CC`, `Bcc`, `Message`) VALUES
('anshu', 'ds', '', '', 'cdsfcsdv');

-- --------------------------------------------------------

--
-- Table structure for table `signupdetails`
--

CREATE TABLE IF NOT EXISTS `signupdetails` (
  `uname` varchar(50) NOT NULL,
  `passwd` varchar(30) NOT NULL,
  `age` int(5) NOT NULL,
  `sex` varchar(6) NOT NULL,
  `city` varchar(50) NOT NULL,
  `state` varchar(50) NOT NULL,
  `pin` varchar(20) NOT NULL,
  `country` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `signupdetails`
--

INSERT INTO `signupdetails` (`uname`, `passwd`, `age`, `sex`, `city`, `state`, `pin`, `country`) VALUES
('gopal', 'asdf', 0, '', '', '', '', ''),
('anshu', 'a', 1, 'Male', 'Hyderabad', 'Andhra Pradesh', '1', 'India');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
