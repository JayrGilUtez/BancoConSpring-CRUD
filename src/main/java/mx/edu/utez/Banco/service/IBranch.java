package mx.edu.utez.Banco.service;


import mx.edu.utez.Banco.model.dto.BranchDto;
import mx.edu.utez.Banco.model.entity.BranchBean;

import java.util.List;

public interface IBranch {
    BranchBean save(BranchDto branch);

    BranchBean findById(Integer id);

    List<BranchBean> findAll();

    void delete(BranchBean branch);
}
