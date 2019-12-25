-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 25, 2019 at 09:07 PM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `intranet`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
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
('praveen', 'anshu', 'ankur', '', '', 12),
('anshu', 'praveen', 'praveen', 'praveen', 'zxcv', 123),
('gopal', 's', 's', 'ss', 'ssss', 1215),
('gopal', 'hg', 'ggh', 'mh', 'hg', 12),
('gopal', 'gh', 'as', 'gfd', 'dsf', 1234);

-- --------------------------------------------------------

--
-- Table structure for table `folders`
--

CREATE TABLE `folders` (
  `uname` varchar(50) NOT NULL,
  `folder` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `folders`
--

INSERT INTO `folders` (`uname`, `folder`) VALUES
('anshu', 'Trash'),
('praveen', 'Trash');

-- --------------------------------------------------------

--
-- Table structure for table `newcompose`
--

CREATE TABLE `newcompose` (
  `mailid` int(25) NOT NULL,
  `mailfrom` varchar(50) NOT NULL,
  `mailto` varchar(50) NOT NULL,
  `subject` varchar(80) NOT NULL,
  `mailcc` varchar(50) NOT NULL,
  `mailbcc` varchar(50) NOT NULL,
  `fileno` varchar(100) NOT NULL DEFAULT '''''',
  `maildata` varchar(99) NOT NULL,
  `folder` varchar(50) NOT NULL,
  `maildate` varchar(35) NOT NULL,
  `mailst` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `newcompose`
--

INSERT INTO `newcompose` (`mailid`, `mailfrom`, `mailto`, `subject`, `mailcc`, `mailbcc`, `fileno`, `maildata`, `folder`, `maildate`, `mailst`) VALUES
(28, 'anshu', 'praveen', 'add', '', '', '', '', 'inbox', 'Tue Oct 30 19:41:41 IST 2012', 0),
(33, 'anshu', 'praveen', '123', '', '', '', 'hello i am new ', 'inbox', 'Tue Oct 30 20:35:30 IST 2012', 0),
(35, 'gopal', 'anshu', 'abc', 'cc', 'bcc', '', 'vghbvgh', 'inbox', 'Mon Nov 05 22:23:54 PST 2012', 0),
(36, 'gopal', 'cc', 'abc', '', 'bcc', '', 'vghbvgh', 'inbox', 'Mon Nov 05 22:23:54 PST 2012', 0),
(39, 'gopal', 'anshu', 'hj', '', '', '', 'jhjkhjknh', 'inbox', 'Tue Nov 06 22:13:00 PST 2012', 0),
(55, 'gopal', 'anshu', 'pro', 'mk', 'nj', '', 'anshu is', 'inbox', 'Tue Nov 06 23:00:52 PST 2012', 0),
(59, 'gopal', 'anshu', '11', '111', '', '', 'dscdsc', 'inbox', 'Wed Nov 07 01:39:15 PST 2012', 0),
(60, 'gopal', '111', '11', '', '', '', 'dscdsc', 'inbox', 'Wed Nov 07 01:39:15 PST 2012', 0),
(63, 'anshu', 'gopal', 'acd', '', '', '', 'ggjf', 'inbox', 'Wed Nov 07 08:29:35 PST 2012', 0),
(65, 'gopal', 'anshu', 'ds', '', '', '', 'cdsfcsdv', 'inbox', 'Wed Nov 07 08:33:58 PST 2012', 0),
(1, 'gopal', 'fkjfkj', 'hjfhfnmfn', '', 'kfjkfjk', '', 'jfkjfkfj', 'inbox', 'Wed Dec 25 22:46:21 IST 2019', 0),
(66, 'praveen', 'anshu', 'test', '', '', '', 'fgggggggggggggggggggg', 'inbox', 'Thu Dec 26 01:16:18 IST 2019', 0),
(67, 'praveen', '', 'test', '', '', '', 'fgggggggggggggggggggg', 'inbox', 'Thu Dec 26 01:16:18 IST 2019', 0),
(68, 'anshu', 'praveen', 'file', '', '', 'Resume_Gopal_updated.docx', 'resume', 'inbox', 'Thu Dec 26 01:19:51 IST 2019', 0),
(69, 'anshu', '', 'file', '', '', '', 'resume', 'inbox', 'Thu Dec 26 01:19:51 IST 2019', 0);

-- --------------------------------------------------------

--
-- Table structure for table `newfolder`
--

CREATE TABLE `newfolder` (
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

CREATE TABLE `sentmail` (
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

CREATE TABLE `signupdetails` (
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
('gopal', 'asd', 0, '', '', '', '', ''),
('anshu', 'a', 1, 'Male', 'Hyderabad', 'Andhra Pradesh', '1', 'India'),
('praveen', '123', 27, 'Male', 'Jaipur', 'Rajasthan', '110092', 'India');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
