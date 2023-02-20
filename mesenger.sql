-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 05, 2020 at 09:09 AM
-- Server version: 10.1.34-MariaDB
-- PHP Version: 7.2.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mesenger`
--

-- --------------------------------------------------------

--
-- Table structure for table `chat_aftab_47874_3501_39944_majid_12207_23723_72691`
--

CREATE TABLE `chat_aftab_47874_3501_39944_majid_12207_23723_72691` (
  `UID` int(255) NOT NULL,
  `FromUID` varchar(255) DEFAULT NULL,
  `ToUID` varchar(255) DEFAULT NULL,
  `Title` varchar(255) DEFAULT NULL,
  `Message` tinytext
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `chat_aftab_47874_3501_39944_majid_12207_23723_72691`
--

INSERT INTO `chat_aftab_47874_3501_39944_majid_12207_23723_72691` (`UID`, `FromUID`, `ToUID`, `Title`, `Message`) VALUES
(1, 'Majid_12207_23723_72691', 'Aftab_47874_3501_39944', 'Majid', 'Hi Majid '),
(2, 'Aftab_47874_3501_39944', 'Majid_12207_23723_72691', 'Aftab', 'Hi Aftab');

-- --------------------------------------------------------

--
-- Table structure for table `chat_arif_59869_63469_21287_faraz_85477_97494_2472`
--

CREATE TABLE `chat_arif_59869_63469_21287_faraz_85477_97494_2472` (
  `UID` int(255) NOT NULL,
  `FromUID` varchar(255) DEFAULT NULL,
  `ToUID` varchar(255) DEFAULT NULL,
  `Title` varchar(255) DEFAULT NULL,
  `Message` tinytext
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `chat_arif_59869_63469_21287_faraz_85477_97494_2472`
--

INSERT INTO `chat_arif_59869_63469_21287_faraz_85477_97494_2472` (`UID`, `FromUID`, `ToUID`, `Title`, `Message`) VALUES
(1, 'Faraz_85477_97494_2472', 'Arif_59869_63469_21287', 'Faraz', 'Hello Dear?'),
(2, 'Arif_59869_63469_21287', 'Faraz_85477_97494_2472', 'Arif', 'Hello too dear '),
(3, 'Faraz_85477_97494_2472', 'Arif_59869_63469_21287', 'Faraz', 'How are u dear?'),
(4, 'Arif_59869_63469_21287', 'Faraz_85477_97494_2472', 'Arif', 'I am fine dear how about u'),
(5, 'Faraz_85477_97494_2472', 'Arif_59869_63469_21287', 'Faraz', 'AlhumdAllah i am fine'),
(6, 'Arif_59869_63469_21287', 'Faraz_85477_97494_2472', 'Arif', 'great!'),
(7, 'Faraz_85477_97494_2472', 'Arif_59869_63469_21287', 'Faraz', 'What are u doing?'),
(8, 'Arif_59869_63469_21287', 'Faraz_85477_97494_2472', 'Arif', 'Nothing specail dear'),
(9, 'Arif_59869_63469_21287', 'Faraz_85477_97494_2472', 'Arif', 'How about u'),
(10, 'Faraz_85477_97494_2472', 'Arif_59869_63469_21287', 'Faraz', 'I am workiing '),
(11, 'Arif_59869_63469_21287', 'Faraz_85477_97494_2472', 'Arif', 'ohh good!');

-- --------------------------------------------------------

--
-- Table structure for table `chat_arif_59869_63469_21287_zoya_12485_23108_3019`
--

CREATE TABLE `chat_arif_59869_63469_21287_zoya_12485_23108_3019` (
  `UID` int(255) NOT NULL,
  `FromUID` varchar(255) DEFAULT NULL,
  `ToUID` varchar(255) DEFAULT NULL,
  `Title` varchar(255) DEFAULT NULL,
  `Message` tinytext
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `chat_arif_59869_63469_21287_zoya_12485_23108_3019`
--

INSERT INTO `chat_arif_59869_63469_21287_zoya_12485_23108_3019` (`UID`, `FromUID`, `ToUID`, `Title`, `Message`) VALUES
(1, 'Zoya_12485_23108_3019', 'Arif_59869_63469_21287', 'Zoya', 'Hello'),
(2, 'Zoya_12485_23108_3019', 'Arif_59869_63469_21287', 'Zoya', 'Hello?'),
(3, 'Arif_59869_63469_21287', 'Zoya_12485_23108_3019', 'Arif', 'Hello Dear How are u');

-- --------------------------------------------------------

--
-- Table structure for table `chat_faraz_85477_97494_2472_zoya_12485_23108_3019`
--

CREATE TABLE `chat_faraz_85477_97494_2472_zoya_12485_23108_3019` (
  `UID` int(255) NOT NULL,
  `FromUID` varchar(255) DEFAULT NULL,
  `ToUID` varchar(255) DEFAULT NULL,
  `Title` varchar(255) DEFAULT NULL,
  `Message` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `chat_faraz_85477_97494_2472_zoya_12485_23108_3019`
--

INSERT INTO `chat_faraz_85477_97494_2472_zoya_12485_23108_3019` (`UID`, `FromUID`, `ToUID`, `Title`, `Message`) VALUES
(1, 'Zoya_12485_23108_3019', 'Faraz_85477_97494_2472', 'Zoya', 'hello my bro'),
(2, 'Faraz_85477_97494_2472', 'Zoya_12485_23108_3019', 'Faraz', 'Hello dear ?'),
(3, 'Zoya_12485_23108_3019', 'Faraz_85477_97494_2472', 'Zoya', 'How are u my bro'),
(4, 'Faraz_85477_97494_2472', 'Zoya_12485_23108_3019', 'Faraz', 'I\'m fine thanks'),
(5, 'Faraz_85477_97494_2472', 'Zoya_12485_23108_3019', 'Faraz', 'What are u doing?'),
(6, 'Zoya_12485_23108_3019', 'Faraz_85477_97494_2472', 'Zoya', 'good'),
(7, 'Zoya_12485_23108_3019', 'Faraz_85477_97494_2472', 'Zoya', 'nothing'),
(8, 'Zoya_12485_23108_3019', 'Faraz_85477_97494_2472', 'Zoya', 'kese ho bro');

-- --------------------------------------------------------

--
-- Table structure for table `chat_imad_75866_80934_32727_arif_59869_63469_21287`
--

CREATE TABLE `chat_imad_75866_80934_32727_arif_59869_63469_21287` (
  `UID` int(255) NOT NULL,
  `FromUID` varchar(255) DEFAULT NULL,
  `ToUID` varchar(255) DEFAULT NULL,
  `Title` varchar(255) DEFAULT NULL,
  `Message` tinytext
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `chat_imad_75866_80934_32727_arif_59869_63469_21287`
--

INSERT INTO `chat_imad_75866_80934_32727_arif_59869_63469_21287` (`UID`, `FromUID`, `ToUID`, `Title`, `Message`) VALUES
(1, 'Arif_59869_63469_21287', 'Imad_75866_80934_32727', 'Arif', 'Hello');

-- --------------------------------------------------------

--
-- Table structure for table `chat_majid_12207_23723_72691_arif_59869_63469_21287`
--

CREATE TABLE `chat_majid_12207_23723_72691_arif_59869_63469_21287` (
  `UID` int(255) NOT NULL,
  `FromUID` varchar(255) DEFAULT NULL,
  `ToUID` varchar(255) DEFAULT NULL,
  `Title` varchar(255) DEFAULT NULL,
  `Message` tinytext
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `chat_majid_12207_23723_72691_arif_59869_63469_21287`
--

INSERT INTO `chat_majid_12207_23723_72691_arif_59869_63469_21287` (`UID`, `FromUID`, `ToUID`, `Title`, `Message`) VALUES
(12, 'Majid_12207_23723_72691', 'Arif_59869_63469_21287', 'Majid', 'How are u'),
(15, 'Majid_12207_23723_72691', 'Arif_59869_63469_21287', 'Majid', 'Hello'),
(16, 'Majid_12207_23723_72691', 'Arif_59869_63469_21287', 'Majid', 'Hello'),
(17, 'Majid_12207_23723_72691', 'Arif_59869_63469_21287', 'Majid', 'it\'s me majid Hussain'),
(20, 'Majid_12207_23723_72691', 'Arif_59869_63469_21287', 'Majid', 'Hello How are u dear'),
(21, 'Arif_59869_63469_21287', 'Majid_12207_23723_72691', 'Arif', 'Hello'),
(22, 'Arif_59869_63469_21287', 'Majid_12207_23723_72691', 'Arif', 'Hi'),
(23, 'Majid_12207_23723_72691', 'Arif_59869_63469_21287', 'Majid', 'HI'),
(24, 'Arif_59869_63469_21287', 'Majid_12207_23723_72691', 'Arif', 'Hello'),
(25, 'Majid_12207_23723_72691', 'Arif_59869_63469_21287', 'Majid', 'Hi'),
(26, 'Arif_59869_63469_21287', 'Majid_12207_23723_72691', 'Arif', 'Hi too'),
(27, 'Majid_12207_23723_72691', 'Arif_59869_63469_21287', 'Majid', 'kese ho bro'),
(28, 'Arif_59869_63469_21287', 'Majid_12207_23723_72691', 'Arif', 'me theek hon ap sunao'),
(29, 'Majid_12207_23723_72691', 'Arif_59869_63469_21287', 'Majid', 'Me b theek ho apke dua se'),
(30, 'Arif_59869_63469_21287', 'Majid_12207_23723_72691', 'Arif', 'good'),
(31, 'Arif_59869_63469_21287', 'Majid_12207_23723_72691', 'Arif', 'Hello');

-- --------------------------------------------------------

--
-- Table structure for table `chat_majid_12207_23723_72691_faraz_85477_97494_2472`
--

CREATE TABLE `chat_majid_12207_23723_72691_faraz_85477_97494_2472` (
  `UID` int(255) NOT NULL,
  `FromUID` varchar(255) DEFAULT NULL,
  `ToUID` varchar(255) DEFAULT NULL,
  `Title` varchar(255) DEFAULT NULL,
  `Message` tinytext
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `chat_majid_12207_23723_72691_faraz_85477_97494_2472`
--

INSERT INTO `chat_majid_12207_23723_72691_faraz_85477_97494_2472` (`UID`, `FromUID`, `ToUID`, `Title`, `Message`) VALUES
(2, 'Majid_12207_23723_72691', 'Faraz_85477_97494_2472', 'Majid', 'Ya Ali as madad faraz!'),
(3, 'Majid_12207_23723_72691', 'Zoya_12485_23108_3019', 'Majid', 'Hello Faraz'),
(5, 'Faraz_85477_97494_2472', 'Majid_12207_23723_72691', 'Faraz', 'Hello Majid Bro How Are u?'),
(6, 'Majid_12207_23723_72691', 'Faraz_85477_97494_2472', 'Majid', 'Im fine My bro How about u'),
(7, 'Faraz_85477_97494_2472', 'Majid_12207_23723_72691', 'Faraz', 'I\'m good thanks'),
(8, 'Majid_12207_23723_72691', 'Faraz_85477_97494_2472', 'Majid', 'What\'s going on now'),
(9, 'Majid_12207_23723_72691', 'Faraz_85477_97494_2472', 'Majid', 'what happened?'),
(10, 'Majid_12207_23723_72691', 'Faraz_85477_97494_2472', 'Majid', 'hell'),
(16, 'Majid_12207_23723_72691', 'Faraz_85477_97494_2472', 'Majid', 'i\'m majid here'),
(17, 'Majid_12207_23723_72691', 'Faraz_85477_97494_2472', 'Majid', 'How are u'),
(18, 'Majid_12207_23723_72691', 'Faraz_85477_97494_2472', 'Majid', 'hello'),
(19, 'Majid_12207_23723_72691', 'Faraz_85477_97494_2472', 'Majid', 'Kese ho bro'),
(20, 'Faraz_85477_97494_2472', 'Majid_12207_23723_72691', 'Faraz', 'me theek ho bhai ap sunao'),
(21, 'Majid_12207_23723_72691', 'Faraz_85477_97494_2472', 'Majid', 'Hello faraz'),
(22, 'Faraz_85477_97494_2472', 'Majid_12207_23723_72691', 'Faraz', 'Hi majid kese ho?');

-- --------------------------------------------------------

--
-- Table structure for table `chat_majid_12207_23723_72691_imad_75866_80934_32727`
--

CREATE TABLE `chat_majid_12207_23723_72691_imad_75866_80934_32727` (
  `UID` int(255) NOT NULL,
  `FromUID` varchar(255) DEFAULT NULL,
  `ToUID` varchar(255) DEFAULT NULL,
  `Title` varchar(255) DEFAULT NULL,
  `Message` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `chat_majid_12207_23723_72691_imad_75866_80934_32727`
--

INSERT INTO `chat_majid_12207_23723_72691_imad_75866_80934_32727` (`UID`, `FromUID`, `ToUID`, `Title`, `Message`) VALUES
(1, 'Imad_75866_80934_32727', 'Majid_12207_23723_72691', 'Imad', 'Hello'),
(2, 'Imad_75866_80934_32727', 'Majid_12207_23723_72691', 'Imad', 'How are u majid'),
(3, 'Majid_12207_23723_72691', 'Imad_75866_80934_32727', 'Majid', 'Hi'),
(4, 'Majid_12207_23723_72691', 'Imad_75866_80934_32727', 'Majid', 'How are u'),
(5, 'Majid_12207_23723_72691', 'Imad_75866_80934_32727', 'Majid', 'Hello'),
(8, 'Majid_12207_23723_72691', 'Imad_75866_80934_32727', 'Majid', 'Hello'),
(9, 'Majid_12207_23723_72691', 'Imad_75866_80934_32727', 'Majid', 'Assalam Alaikum Imad Bhai');

-- --------------------------------------------------------

--
-- Table structure for table `chat_zoya_12485_23108_3019_majid_12207_23723_72691`
--

CREATE TABLE `chat_zoya_12485_23108_3019_majid_12207_23723_72691` (
  `UID` int(255) NOT NULL,
  `FromUID` varchar(255) DEFAULT NULL,
  `ToUID` varchar(255) DEFAULT NULL,
  `Title` varchar(255) DEFAULT NULL,
  `Message` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `chat_zoya_12485_23108_3019_majid_12207_23723_72691`
--

INSERT INTO `chat_zoya_12485_23108_3019_majid_12207_23723_72691` (`UID`, `FromUID`, `ToUID`, `Title`, `Message`) VALUES
(1, 'Majid_12207_23723_72691', 'Zoya_12485_23108_3019', 'Majid', 'Hello It\'s me majid hussain\r\n'),
(2, 'Zoya_12485_23108_3019', 'Majid_12207_23723_72691', 'Zoya', 'Hello Majid How are u ? '),
(3, 'Zoya_12485_23108_3019', 'Majid_12207_23723_72691', 'Zoya', 'What are u doing now? '),
(4, 'Majid_12207_23723_72691', 'Majid_12207_23723_72691', 'Majid', 'dear sis Im operating laptop'),
(5, 'Zoya_12485_23108_3019\r\n', 'Majid_12207_23723_72691', 'Zoya', 'Ohh good!\r\n'),
(6, 'Majid_12207_23723_72691', 'Zoya_12485_23108_3019', 'Zoya', 'hello'),
(7, 'Majid_12207_23723_72691', 'Zoya_12485_23108_3019', 'Zoya', 'I\'m majid'),
(8, 'Majid_12207_23723_72691', 'Zoya_12485_23108_3019', 'Zoya', 'hello'),
(9, 'Majid_12207_23723_72691', 'Zoya_12485_23108_3019', 'Majid', 'yes'),
(10, 'Majid_12207_23723_72691', 'Zoya_12485_23108_3019', 'Majid', 'I\'m nere here'),
(11, 'Majid_12207_23723_72691', 'Zoya_12485_23108_3019', 'Majid', 'yes'),
(12, 'Majid_12207_23723_72691', 'Zoya_12485_23108_3019', 'Majid', 'yes'),
(13, 'Majid_12207_23723_72691', 'Zoya_12485_23108_3019', 'Majid', 'Ya Ali as Madad'),
(14, 'Majid_12207_23723_72691', 'Zoya_12485_23108_3019', 'Majid', 'Hello'),
(15, 'Majid_12207_23723_72691', 'Zoya_12485_23108_3019', 'Majid', 'yes'),
(16, 'Majid_12207_23723_72691', 'Zoya_12485_23108_3019', 'Majid', 'Im majid'),
(17, 'Majid_12207_23723_72691', 'Zoya_12485_23108_3019', 'Majid', 'HELLO'),
(18, 'Majid_12207_23723_72691', 'Zoya_12485_23108_3019', 'Majid', 'Hello dear'),
(20, 'Majid_12207_23723_72691', 'Zoya_12485_23108_3019', 'Majid', 'hello'),
(21, 'Majid_12207_23723_72691', 'Zoya_12485_23108_3019', 'Majid', 'How are u'),
(22, 'Majid_12207_23723_72691', 'Zoya_12485_23108_3019', 'Majid', 'hello'),
(23, 'Majid_12207_23723_72691', 'Zoya_12485_23108_3019', 'Majid', 'how are u'),
(24, 'Majid_12207_23723_72691', 'Zoya_12485_23108_3019', 'Majid', 'hello'),
(25, 'Zoya_12485_23108_3019', 'Majid_12207_23723_72691', 'Zoya', 'kese ho ap'),
(26, 'Majid_12207_23723_72691', 'Zoya_12485_23108_3019', 'Majid', 'Hello'),
(27, 'Majid_12207_23723_72691', 'Zoya_12485_23108_3019', 'Majid', 'hello'),
(28, 'Zoya_12485_23108_3019', 'Majid_12207_23723_72691', 'Zoya', 'Hi majid how are you?'),
(29, 'Majid_12207_23723_72691', 'Zoya_12485_23108_3019', 'Majid', 'Hello zoya kia kar rahi ho?'),
(30, 'Majid_12207_23723_72691', 'Zoya_12485_23108_3019', 'Majid', 'free bethi ho Ap?'),
(31, 'Majid_12207_23723_72691', 'Zoya_12485_23108_3019', 'Majid', 'jddsfjsl fjlsfjsldf jlsdfjdslf jslfjlsd fjsldf jlsfjlsfj lsfjls fjlsjlsf jslfj slfjslf'),
(32, 'Majid_12207_23723_72691', 'Zoya_12485_23108_3019', 'Majid', 'Hello'),
(33, 'Majid_12207_23723_72691', 'Zoya_12485_23108_3019', 'Majid', 'hi'),
(34, 'Zoya_12485_23108_3019', 'Majid_12207_23723_72691', 'Zoya', 'Hi'),
(35, 'Zoya_12485_23108_3019', 'Majid_12207_23723_72691', 'Zoya', 'How are you? '),
(36, 'Majid_12207_23723_72691', 'Zoya_12485_23108_3019', 'Majid', 'Hello Zoya kesi ho yar wo Networking ke notes tu maine study karni hai plz aur mathematics bhi parha du sir ne buhat burden rakha hai ke logical kam karo ab logical kam tu maths aur physics se he hoga so plz parha do na '),
(37, 'Majid_12207_23723_72691', 'Zoya_12485_23108_3019', 'Majid', 'hello'),
(38, 'Majid_12207_23723_72691', 'Zoya_12485_23108_3019', 'Majid', 'When the first digital computers appeared in the early 1940s,[5] the instructions to make them operate were wired into the machine. Practitioners quickly realized that this design was not flexible and came up with the \"stored program architecture\" or von Neumann architecture. Thus the division between \"hardware\" and \"software\" began with abstraction being used to deal with the complexity of computing.'),
(41, 'Zoya_12485_23108_3019', 'Majid_12207_23723_72691', 'Zoya', 'hello'),
(42, 'Majid_12207_23723_72691', 'Zoya_12485_23108_3019', 'Majid', 'Hello ');

-- --------------------------------------------------------

--
-- Table structure for table `conversion`
--

CREATE TABLE `conversion` (
  `UID` int(255) NOT NULL,
  `unique_id` varchar(255) NOT NULL,
  `unique_from` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `message` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `conversion`
--

INSERT INTO `conversion` (`UID`, `unique_id`, `unique_from`, `firstname`, `message`) VALUES
(1, 'majid_123', 'faraz_123', 'majid', 'majid hussain');

-- --------------------------------------------------------

--
-- Table structure for table `securety`
--

CREATE TABLE `securety` (
  `SID` int(255) NOT NULL,
  `Question_One` varchar(255) NOT NULL,
  `Question_Two` varchar(255) NOT NULL,
  `Answer_One` varchar(255) NOT NULL,
  `Answer_Two` varchar(255) NOT NULL,
  `unique_id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `securety`
--

INSERT INTO `securety` (`SID`, `Question_One`, `Question_Two`, `Answer_One`, `Answer_Two`, `unique_id`) VALUES
(1, 'What was the name of your primary school', 'What is your lucky number', 'Darya Khan', '4', 'Zoya_12485_23108_3019'),
(2, 'What was your childhood friends name', 'Who is your best friend', 'majid', 'majid', 'Faraz_85477_97494_2472'),
(3, 'What was the name of your primary school', 'What is your dream job', 'Darya Khan', 'Software Eng', 'Majid_12207_23723_72691'),
(4, 'What was the name of your primary school', 'What is your dream job', 'Darya Khan', 'Software Eng', 'Arif_59869_63469_21287'),
(5, 'What was the name of your primary school', 'What is your dream job', 'Single section', 'Freelancer', 'Imad_75866_80934_32727'),
(6, 'What was your childhood friends name', 'Who is your best friend', 'Majid Hussain Qutriyo', 'Majid Hussain Qutrio', 'Aftab_47874_3501_39944');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `UID` int(255) NOT NULL,
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Firstname` varchar(255) NOT NULL,
  `Lastname` varchar(255) NOT NULL,
  `unique_id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`UID`, `Username`, `Password`, `Firstname`, `Lastname`, `unique_id`) VALUES
(10, 'Zoya Naz', 'zoya123', 'Zoya', 'Naz', 'Zoya_12485_23108_3019'),
(11, 'Faraz Ahmed', 'faraz123', 'Faraz', 'Ahmed', 'Faraz_85477_97494_2472'),
(12, 'Majid Hussain', 'majid', 'Majid', 'Hussain', 'Majid_12207_23723_72691'),
(13, 'Arif Hussain', 'arif', 'Arif', 'Hussain', 'Arif_59869_63469_21287'),
(14, 'Imad Jarwar', 'imad123', 'Imad', 'Jarwar', 'Imad_75866_80934_32727'),
(15, 'Aftab Khokhar', 'aftab456', 'Aftab', 'Khokhar', 'Aftab_47874_3501_39944');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chat_aftab_47874_3501_39944_majid_12207_23723_72691`
--
ALTER TABLE `chat_aftab_47874_3501_39944_majid_12207_23723_72691`
  ADD PRIMARY KEY (`UID`);

--
-- Indexes for table `chat_arif_59869_63469_21287_faraz_85477_97494_2472`
--
ALTER TABLE `chat_arif_59869_63469_21287_faraz_85477_97494_2472`
  ADD PRIMARY KEY (`UID`);

--
-- Indexes for table `chat_arif_59869_63469_21287_zoya_12485_23108_3019`
--
ALTER TABLE `chat_arif_59869_63469_21287_zoya_12485_23108_3019`
  ADD PRIMARY KEY (`UID`);

--
-- Indexes for table `chat_faraz_85477_97494_2472_zoya_12485_23108_3019`
--
ALTER TABLE `chat_faraz_85477_97494_2472_zoya_12485_23108_3019`
  ADD PRIMARY KEY (`UID`);

--
-- Indexes for table `chat_imad_75866_80934_32727_arif_59869_63469_21287`
--
ALTER TABLE `chat_imad_75866_80934_32727_arif_59869_63469_21287`
  ADD PRIMARY KEY (`UID`);

--
-- Indexes for table `chat_majid_12207_23723_72691_arif_59869_63469_21287`
--
ALTER TABLE `chat_majid_12207_23723_72691_arif_59869_63469_21287`
  ADD PRIMARY KEY (`UID`);

--
-- Indexes for table `chat_majid_12207_23723_72691_faraz_85477_97494_2472`
--
ALTER TABLE `chat_majid_12207_23723_72691_faraz_85477_97494_2472`
  ADD PRIMARY KEY (`UID`);

--
-- Indexes for table `chat_majid_12207_23723_72691_imad_75866_80934_32727`
--
ALTER TABLE `chat_majid_12207_23723_72691_imad_75866_80934_32727`
  ADD PRIMARY KEY (`UID`);

--
-- Indexes for table `chat_zoya_12485_23108_3019_majid_12207_23723_72691`
--
ALTER TABLE `chat_zoya_12485_23108_3019_majid_12207_23723_72691`
  ADD PRIMARY KEY (`UID`);

--
-- Indexes for table `conversion`
--
ALTER TABLE `conversion`
  ADD PRIMARY KEY (`UID`);

--
-- Indexes for table `securety`
--
ALTER TABLE `securety`
  ADD PRIMARY KEY (`SID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`UID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chat_aftab_47874_3501_39944_majid_12207_23723_72691`
--
ALTER TABLE `chat_aftab_47874_3501_39944_majid_12207_23723_72691`
  MODIFY `UID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `chat_arif_59869_63469_21287_faraz_85477_97494_2472`
--
ALTER TABLE `chat_arif_59869_63469_21287_faraz_85477_97494_2472`
  MODIFY `UID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `chat_arif_59869_63469_21287_zoya_12485_23108_3019`
--
ALTER TABLE `chat_arif_59869_63469_21287_zoya_12485_23108_3019`
  MODIFY `UID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `chat_faraz_85477_97494_2472_zoya_12485_23108_3019`
--
ALTER TABLE `chat_faraz_85477_97494_2472_zoya_12485_23108_3019`
  MODIFY `UID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `chat_imad_75866_80934_32727_arif_59869_63469_21287`
--
ALTER TABLE `chat_imad_75866_80934_32727_arif_59869_63469_21287`
  MODIFY `UID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `chat_majid_12207_23723_72691_arif_59869_63469_21287`
--
ALTER TABLE `chat_majid_12207_23723_72691_arif_59869_63469_21287`
  MODIFY `UID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `chat_majid_12207_23723_72691_faraz_85477_97494_2472`
--
ALTER TABLE `chat_majid_12207_23723_72691_faraz_85477_97494_2472`
  MODIFY `UID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `chat_majid_12207_23723_72691_imad_75866_80934_32727`
--
ALTER TABLE `chat_majid_12207_23723_72691_imad_75866_80934_32727`
  MODIFY `UID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `chat_zoya_12485_23108_3019_majid_12207_23723_72691`
--
ALTER TABLE `chat_zoya_12485_23108_3019_majid_12207_23723_72691`
  MODIFY `UID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT for table `conversion`
--
ALTER TABLE `conversion`
  MODIFY `UID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `securety`
--
ALTER TABLE `securety`
  MODIFY `SID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `UID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
