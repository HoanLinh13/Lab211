package view;

import controller.CandidateManager;
import model.Candidate;
import model.Experience;
import model.Fresher;
import model.Intern;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private CandidateManager manager = new CandidateManager();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\nCandidate Management System");
            System.out.println("1. Add Experience Candidate");
            System.out.println("2. Add Fresher Candidate");
            System.out.println("3. Add Intern Candidate");
            System.out.println("4. Show all Candidates");
            System.out.println("5. Search Candidate by Name");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addExperience();
                    break;
                case 2:
                    addFresher();
                    break;
                case 3:
                    addIntern();
                    break;
                case 4:
                    manager.displayAllCandidates();
                    break;
                case 5:
                    searchCandidate();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private void addExperience() {
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter Years of Experience: ");
        int expYears = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Professional Skill: ");
        String skill = scanner.nextLine();

        manager.addCandidate(new Experience(id, firstName, lastName, expYears, skill));
        System.out.println("Experience Candidate added!");
    }

    private void addFresher() {
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter Graduation Date: ");
        Date gradDate = new Date(); // Giả sử lấy ngày hiện tại
        System.out.print("Enter Graduation Rank: ");
        String rank = scanner.nextLine();
        System.out.print("Enter University Name: ");
        String university = scanner.nextLine();

        manager.addCandidate(new Fresher(id, firstName, lastName, gradDate, rank, university));
        System.out.println("Fresher Candidate added!");
    }

    private void addIntern() {
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter Major: ");
        String major = scanner.nextLine();
        System.out.print("Enter Semester: ");
        String semester = scanner.nextLine();
        System.out.print("Enter University Name: ");
        String university = scanner.nextLine();

        manager.addCandidate(new Intern(id, firstName, lastName, major, semester, university));
        System.out.println("Intern Candidate added!");
    }

    private void searchCandidate() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();
        List<Candidate> results = manager.searchByName(name);
        for (Candidate c : results) {
            c.showInfo();
        }
    }
}
