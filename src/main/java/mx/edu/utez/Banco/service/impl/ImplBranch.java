package mx.edu.utez.Banco.service.impl;

import mx.edu.utez.Banco.model.dao.BranchDao;
import mx.edu.utez.Banco.model.dto.BranchDto;
import mx.edu.utez.Banco.model.entity.BranchBean;
import mx.edu.utez.Banco.service.IBranch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImplBranch implements IBranch {

    @Autowired
    private BranchDao branchDao;

    @Override
    @Transactional
    public BranchBean save(BranchDto branchDto) {
        BranchBean branch = BranchBean.builder()
                .idBranch(branchDto.getId_branch())
                .code(branchDto.getCode())
                .address(branchDto.getAddress())
                .name(branchDto.getName())
                .build();
        return branchDao.save(branch);
    }

    @Override
    @Transactional(readOnly = true)
    public BranchBean findById(Integer id) {
        return branchDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<BranchBean> findAll() {
        return (List<BranchBean>) branchDao.findAll();
    }

    @Override
    @Transactional
    public void delete(BranchBean branch) {
        branchDao.delete(branch);
    }
}
