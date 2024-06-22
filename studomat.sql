-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 22, 2024 at 03:02 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `studomat`
--

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `ID` int(6) NOT NULL,
  `Name` varchar(35) NOT NULL,
  `Description` varchar(70) DEFAULT NULL,
  `Semester` int(10) NOT NULL,
  `ECTS` int(3) NOT NULL,
  `Grade` int(1) NOT NULL,
  `IdProfessor` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_croatian_ci;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`ID`, `Name`, `Description`, `Semester`, `ECTS`, `Grade`, `IdProfessor`) VALUES
(1, 'Java Programming Language', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. ', 5, 5, 0, 1),
(2, 'C# Programming Language', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. ', 4, 2, 1, 5),
(5, 'Mathematics 1', 'Familiarising with terms related to mathematical analysis and linear a', 1, 7, 0, 4),
(6, 'Technical English 2', 'Developing students\' ability to use the English language related to sp', 2, 2, 0, 10),
(7, 'Digital Techniques', 'To acquire basic knowledge of digital techniques.', 3, 6, 0, 11);

-- --------------------------------------------------------

--
-- Table structure for table `professors`
--

CREATE TABLE `professors` (
  `ID` int(6) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Surname` varchar(30) NOT NULL,
  `OIB` varchar(11) NOT NULL,
  `Username` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_croatian_ci;

--
-- Dumping data for table `professors`
--

INSERT INTO `professors` (`ID`, `Name`, `Surname`, `OIB`, `Username`, `Password`) VALUES
(1, 'Kresimir', 'Markota', '12345671234', 'kmarkota', 'markota1'),
(4, 'Ivana', 'Marušić', '12345671232', 'imarusic', 'imarusic11'),
(5, 'Krunoslav', 'Husak', '21398716251', 'khusak', 'khusak2'),
(10, 'Ivana', 'Jurković', '47895678410', 'ijurkovic', 'ijurkovic3'),
(11, 'Dario', 'Vidić', '74102859741', 'dvidic', 'dvidic6');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `ID` int(6) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Surname` varchar(30) NOT NULL,
  `OIB` varchar(11) NOT NULL,
  `JMBAG` varchar(10) NOT NULL,
  `Username` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_croatian_ci;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`ID`, `Name`, `Surname`, `OIB`, `JMBAG`, `Username`, `Password`) VALUES
(1, 'Leon', 'Lucic', '28497742860', '0165721074', 'llucic', 'koliko99');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `IdProfessor` (`IdProfessor`);

--
-- Indexes for table `professors`
--
ALTER TABLE `professors`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `OIB` (`OIB`),
  ADD UNIQUE KEY `Username` (`Username`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `Username` (`Username`),
  ADD UNIQUE KEY `OIB` (`OIB`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `courses`
--
ALTER TABLE `courses`
  MODIFY `ID` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `professors`
--
ALTER TABLE `professors`
  MODIFY `ID` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `ID` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `courses`
--
ALTER TABLE `courses`
  ADD CONSTRAINT `courses_ibfk_1` FOREIGN KEY (`IdProfessor`) REFERENCES `professors` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
