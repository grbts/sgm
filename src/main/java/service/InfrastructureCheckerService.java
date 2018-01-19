package service;

import dao.InfrastructureCheckerDAO;
import dto.InfrastructureCheckerDTO;

import java.io.IOException;

public class InfrastructureCheckerService {

    public Boolean checkInfrastructure() {

        InfrastructureCheckerDTO infrastructureCheckerDTO = null;
        InfrastructureCheckerDAO infrastructureCheckerDAO = new InfrastructureCheckerDAO();
        try {
            infrastructureCheckerDTO = infrastructureCheckerDAO.getInfrastructureInformation();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert infrastructureCheckerDTO != null;
        int total = infrastructureCheckerDTO.getElements().getTags().getTotal();
        return total > 0;
    }

}
