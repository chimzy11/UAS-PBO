-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 11 Jun 2023 pada 15.13
-- Versi server: 10.4.24-MariaDB
-- Versi PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbobat`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_keranjang`
--

CREATE TABLE `tb_keranjang` (
  `id_keranjang` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `subtotal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_keranjang`
--

INSERT INTO `tb_keranjang` (`id_keranjang`, `nama`, `jumlah`, `subtotal`) VALUES
(21, 'Theophylline', 1, 50000),
(22, 'Dextromethorphan', 1, 80000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_login`
--

CREATE TABLE `tb_login` (
  `id_akun` int(11) NOT NULL,
  `Nama` varchar(255) NOT NULL,
  `Username` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Status` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_login`
--

INSERT INTO `tb_login` (`id_akun`, `Nama`, `Username`, `Email`, `Password`, `Status`) VALUES
(1, 'Cough Medicane Store', 'Healed', 'Healed@gmail.com', '123', 'Admin'),
(2, 'Rismayanti', 'Chimaa', 'Chimaa@gmail.com', '123', 'USER'),
(8, 'Zyaan Gefariel Al-Husayyn', 'Zyaan', 'Zyaan@gmail.com', '123', 'USER');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_obat`
--

CREATE TABLE `tb_obat` (
  `id_obat` int(11) NOT NULL,
  `nama` varchar(255) NOT NULL,
  `indikasi` varchar(20) NOT NULL,
  `bentuk` varchar(50) NOT NULL,
  `expired` varchar(50) NOT NULL,
  `efek_samping` varchar(255) NOT NULL,
  `dosis` varchar(20) NOT NULL,
  `stok` int(11) NOT NULL,
  `harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_obat`
--

INSERT INTO `tb_obat` (`id_obat`, `nama`, `indikasi`, `bentuk`, `expired`, `efek_samping`, `dosis`, `stok`, `harga`) VALUES
(11, 'Theophylline', 'Batuk Berdahak', 'Tablet', '2024-02-09', 'Gangguan Pencernaan', '3 Tablet', 3, 50000),
(15, 'Dextromethorphan', 'Batuk Kering', 'Sirup', '2025-04-03', 'Gatal', '5 Sirup', 27, 80000),
(16, 'Mucolytics', 'Batuk Berdahak', 'Kapsul', '2027-10-04', 'Pusing', '1 Kapsul', 26, 30000),
(17, 'Guaifenesin', 'Batuk Alergi', 'Tetes', '2026-02-01', 'Mual', '2 Tetes', 24, 60000),
(18, 'Albuterol', 'Batuk Berdahak', 'Inhaler', '2027-03-02', 'Mual', '5 Inhaler', 10, 140000),
(19, 'Benzocaine', 'Batuk Berkepanjangan', 'Spray tenggorokan', '2028-04-13', 'Pusing', '3 Spray tenggorokan', 19, 400000),
(20, 'Lidocaine', 'Batuk Berkepanjangan', 'Spray tenggorokan', '2027-10-05', 'Gatal', '5 Spray tenggorokan', 5, 95000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_transaksi`
--

CREATE TABLE `tb_transaksi` (
  `id_transaksi` int(11) NOT NULL,
  `nama_lengkap` varchar(255) NOT NULL,
  `bank` varchar(10) NOT NULL,
  `norek` varchar(50) NOT NULL,
  `total_transaksi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_transaksi`
--

INSERT INTO `tb_transaksi` (`id_transaksi`, `nama_lengkap`, `bank`, `norek`, `total_transaksi`) VALUES
(1, 'Zyaan Gefariel Al-Husaynn', 'Mandiri', '1234567890', 315000),
(2, 'Rismayanti', 'BCA', '1234567891', 315000),
(3, 'Oliv Fiah', 'Mandiri', '1234567892', 150000),
(4, 'Samsurian', 'BRI', '1234567893', 50000),
(5, 'Rismayanti', 'Mandiri', '1234567891', 940000);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tb_keranjang`
--
ALTER TABLE `tb_keranjang`
  ADD PRIMARY KEY (`id_keranjang`);

--
-- Indeks untuk tabel `tb_login`
--
ALTER TABLE `tb_login`
  ADD PRIMARY KEY (`id_akun`);

--
-- Indeks untuk tabel `tb_obat`
--
ALTER TABLE `tb_obat`
  ADD PRIMARY KEY (`id_obat`);

--
-- Indeks untuk tabel `tb_transaksi`
--
ALTER TABLE `tb_transaksi`
  ADD PRIMARY KEY (`id_transaksi`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tb_keranjang`
--
ALTER TABLE `tb_keranjang`
  MODIFY `id_keranjang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT untuk tabel `tb_login`
--
ALTER TABLE `tb_login`
  MODIFY `id_akun` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT untuk tabel `tb_obat`
--
ALTER TABLE `tb_obat`
  MODIFY `id_obat` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT untuk tabel `tb_transaksi`
--
ALTER TABLE `tb_transaksi`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
