package com.bookms;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

import com.bookms.enumeration.Genre;
import com.bookms.enumeration.SeatStatus;
import com.bookms.enumeration.SeatType;
import com.bookms.model.Address;
import com.bookms.model.Admin;
import com.bookms.model.Audi;
import com.bookms.model.CinemaHall;
import com.bookms.model.Member;
import com.bookms.model.Movie;
import com.bookms.model.Seat;
import com.bookms.model.Show;
import com.bookms.model.SystemMember;

public class BookMyShow {
	
	public static void main(String[] args) {
		DataCache.USERS.add(new Member("bk", "bk", "Balakumar"));
		
		Admin admin = new Admin("admin", "admin", "Bala");
		
		Movie rrr = new Movie(1, "RRR", 3, "Telugu", Genre.ACTION, LocalDate.of(2022, Month.APRIL, 5));
		Movie beast = new Movie(2, "Beast", 2, "Tamil", Genre.COMEDY, LocalDate.of(2022, Month.MAY, 2));
		
		admin.addMovie(rrr);
		admin.addMovie(beast);
		
		List<Seat> rrrSeats = new ArrayList<>();
		rrrSeats.add(new Seat(1, SeatType.ECONOMY, SeatStatus.AVAILABLE, 150));
		rrrSeats.add(new Seat(2, SeatType.VIP, SeatStatus.AVAILABLE, 150));
		rrrSeats.add(new Seat(3, SeatType.VIP, SeatStatus.AVAILABLE, 150));
		Show rrrShow = new Show(1, 1, LocalDate.now(), LocalTime.of(10, 00), 1, rrrSeats);
		
		List<Seat> beastSeats = new ArrayList<>();
		beastSeats.add(new Seat(1, SeatType.DELUXE, SeatStatus.AVAILABLE, 150));
		beastSeats.add(new Seat(2, SeatType.DELUXE, SeatStatus.AVAILABLE, 150));
		beastSeats.add(new Seat(3, SeatType.VIP, SeatStatus.AVAILABLE, 150));
		Show beastShow = new Show(1, 2, LocalDate.now(), LocalTime.of(12, 00), 2, beastSeats);
		
		admin.addShow(rrrShow);
		admin.addShow(beastShow);
		
		Address inoxAddress = new Address("Vishal De Mall", "Madurai", 626046, "Tamilnadu", "India");
		Audi audi1 = new Audi(1, "Audi 1", 10, Arrays.asList(rrrShow));
		List<Audi> inoxAudis = Arrays.asList(audi1);
		
		CinemaHall inox = new CinemaHall(1, "INOX", inoxAddress, inoxAudis);
		
		Address satyamAddress = new Address("Mount Road", "Chennai", 626102, "Tamilnadu", "India");
		audi1 = new Audi(1, "Audi 1", 10, Arrays.asList(beastShow));
		List<Audi> satyamAudis = Arrays.asList(audi1);
		
		CinemaHall satyam = new CinemaHall(2, "Satyam", satyamAddress, satyamAudis);
		
		admin.addCinema(inox);
		admin.addCinema(satyam);
		
		admin.prepare();
		
		try (Scanner scanner = new Scanner(System.in);) {
			while (true) {
				Init(scanner);
			}
		}
	}

	private static void Init(Scanner scanner) {
		System.out.println("Enter user name: ");
		String username = scanner.nextLine();
		
		Optional<SystemMember> optional = DataCache.USERS.stream().filter(u -> u.userName.equals(username)).map(user -> {
			if (user.isAdmin)
				return (Admin) user;
			else
				return (Member) user;
		}).findFirst();
		if (optional.isPresent()) {
			SystemMember systemMember = optional.get();
			validateMember(scanner, systemMember);
		} else {
			System.out.println("Invalid User..");
			System.out.println("1. Create User \n2.Exit");
			switch (Integer.parseInt(scanner.nextLine())) {
				case 1:
					createUser(scanner);
					Init(scanner);
					break;
				case 2:
					System.exit(1);
					break;
			}
		}
	}

	private static void createUser(Scanner scanner) {
		System.out.println("Enter Username : ");
		String userName = scanner.nextLine();
		System.out.println("Enter Password : ");
		String password = scanner.nextLine();
		System.out.println("Enter Full Name : ");
		String name = scanner.nextLine();
		
		Member member = new Member(userName, password, name);
		DataCache.USERS.add(member);
	}

	private static void validateMember(Scanner scanner, SystemMember systemMember) {
		System.out.println("Enter password: \nEnter '0' to exit");
		String pwd = scanner.nextLine();
		if (pwd.equals("0")) {
			System.exit(1);
		}
		if (systemMember.password.equals(pwd))  {
			System.out.println(String.format("Welcome %s !", systemMember.name));
			if (systemMember.isAdmin) {
				playAsAdmin(scanner);
			} else {
				playAsMember(scanner, systemMember);
			}
		} else {
			System.out.println("Incorrect credentials..please try again");
			validateMember(scanner, systemMember);
		}
	}

	private static boolean playAsAdmin(Scanner scanner) {
		return false;
	}

	private static boolean playAsMember(Scanner scanner, SystemMember systemMember) {
		Member member = (Member) systemMember;
		while (true) {
			System.out.println("1. Get Movies \n2. Get Cinemas \n3. Exit");
			switch (Integer.parseInt(scanner.nextLine())) {
				case 1:
					filterMovies(scanner, member);
					break;
				case 2:
					System.out.print("Enter City: ");
					member.getCinemaHall(scanner.nextLine());
					break;
				case 3:
					System.exit(1);
					break;
				default:
					System.out.println("Invalid selection...");
			}
		}
	}

	private static boolean filterMovies(Scanner scanner, Member member) {
		while (true) {
			System.out.println("Search By : ");
			System.out.println("1. City & Date \n2. Name \n3. Genre \n4. Language \n5. Release Date \n6. Back");
			switch (Integer.parseInt(scanner.nextLine())) {
				case 1:
					System.out.print("Enter City: ");
					String city = scanner.nextLine();
					System.out.println("Enter Date(DD-MM-YYYY): ");
					String date = scanner.nextLine();
					LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
					member.getMovies(localDate, city);		
					break;
				case 2:
					System.out.print("Enter Movie Name: ");
					member.searchObj.searchMovieByNames(scanner.nextLine()).forEach(System.out::println);
					break;
				case 3:
					System.out.print("Enter Genre: ");
					String genre = scanner.nextLine();
					Optional<Genre> genreOpt = Stream.of(Genre.values()).filter(gen -> gen.name().equalsIgnoreCase(genre)).findFirst();
					if (genreOpt.isPresent()) {
						member.searchObj.searchMovieByGenre(genreOpt.get()).forEach(System.out::println);
					} else {
						System.out.println("Invalid Genre..");
						filterMovies(scanner, member);
					}
					break;
				case 4:
					System.out.print("Enter Language: ");
					member.searchObj.searchMovieByLanguage(scanner.nextLine()).forEach(System.out::println);
					break;
				case 5:
					System.out.println("Enter Release Date(DD-MM-YYYY): ");
					member.searchObj.searchMovieByDate(LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"))).forEach(System.out::println);
					break;
				case 6:
					return false;
				default:
					System.out.println("Invalid Options..");
			}
		}
	}

}
