package views;

import controllers.HomeController;
import controllers.JobController;
import models.Job;

public class JobView implements BaseView{
    String jobId;

    @Override
    public void display() {
        int option = 0;
        System.out.println("Showing menu under Job");
        System.out.println("1. Add job");
        System.out.println("2. Show job by ID");
        System.out.println("3. Show all job");
        System.out.println("0. Back");

        System.out.print("your choice : ");
        option = scanner.nextInt();

        System.out.println("=================================");

        switch(option){
            case 1:
                new JobController().form(1);
                break;
            case 2:
                new JobController().showSingle();
                break;
            case 3:
                new JobController().showAll();
                break;
            case 0:
                new HomeController().start();

        }
    }

    @Override
    public void form(int type) {
        Job job = new Job();
        System.out.println("=============================");

        if(type == 1){
            System.out.print("Job ID : ");
            job.setId(scanner.next());
        }else{
            System.out.println("Job ID : " + jobId);
            job.setId(jobId);
        }
        scanner.nextLine();
        System.out.print("Job name : ");
        job.setTitle(scanner.nextLine());
        System.out.print("Min Salary : ");
        job.setMinSalary(scanner.nextDouble());
        System.out.print("Max Salary : ");
        job.setMaxSalary(scanner.nextDouble());
        System.out.println("================================");

        String result = new JobController().save(job) ? "Succesfully" : "Failed";
        System.out.println(result);

        System.out.println("================================");

        this.display();
    }

    @Override
    public void show() {

        System.out.print("Enter Job ID : ");
        jobId = scanner.next();
        System.out.println();
        System.out.println("Searching..");
        System.out.println();

        Job job = new JobController().getById(jobId);

        if(job != null){
            System.out.println("Job ID : " + job.getId());
            System.out.println("Job name : " + job.getTitle());
            System.out.println("Min salary : " + job.getMinSalary());
            System.out.println("Max salary : " + job.getMaxsalary());
            System.out.println("=================================");
            System.out.println("1. Update Job");
            System.out.println("2. Delete Job");
            System.out.println("0. Back");
            System.out.print("your choice : ");
            int option = scanner.nextInt();

            System.out.println("=================================");
            switch(option){
                case 1:
                    this.form(2);
                    break;
                case 2:
                    new JobController().delete(job.getId());
                    System.out.println("Job Deleted!");
                    System.out.println("====================================");
                    this.display();
                    break;
                case 0:
                    this.display();
                    break;
                default:
                    this.display();
            }
        }else{
            System.out.println("Sorry Job with id " +jobId+ " not found!");
        }
    }

    @Override
    public void showAll() {
        for (Job job : new JobController().getAll()) {
            System.out.println("Job ID : " + job.getId());
            System.out.println("Job name : " + job.getTitle());
            System.out.println("Min Salary : " + job.getMinSalary());
            System.out.println("Max Salary : " + job.getMaxsalary());
            System.out.println("=================================");
        }
        System.out.println("0. Back");
        System.out.print("your choice : ");
        if(scanner.nextInt() == 0){
            this.display();
        }
    }
}
