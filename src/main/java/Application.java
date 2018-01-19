import service.InfrastructureCheckerService;

public class Application {

    public static void main(String[] args) {
        InfrastructureCheckerService infrastructureCheckerService = new InfrastructureCheckerService();
        boolean isPassed = infrastructureCheckerService.checkInfrastructure();
        System.out.println("Verification passed: " + isPassed);
    }

}