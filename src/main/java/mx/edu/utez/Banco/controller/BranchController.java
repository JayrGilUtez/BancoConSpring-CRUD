package mx.edu.utez.Banco.controller;

import mx.edu.utez.Banco.model.dto.BranchDto;
import mx.edu.utez.Banco.model.entity.BranchBean;
import mx.edu.utez.Banco.service.IBranch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/branch")
@CrossOrigin
public class BranchController {
    @Autowired
    private IBranch branchService;

    @GetMapping("/")
    public List<BranchBean> getBranch() {
        return branchService.findAll();
    }

    @GetMapping("/{id}")
    public BranchBean showById(@PathVariable Integer id) {
        return branchService.findById(id);
    }

    @PostMapping("/")
    public BranchDto create(@RequestBody BranchDto branchDto) {
        BranchBean branchSave = branchService.save(branchDto);
        return BranchDto.builder()
                .id_branch(branchSave.getIdBranch())
                .code(branchSave.getCode())
                .address(branchSave.getAddress())
                .name(branchSave.getName())
                .build();
    }

    @PutMapping("/")
    public BranchDto update(@RequestBody BranchDto branchDto) {
        BranchBean branchUpdate = branchService.save(branchDto);
        return BranchDto.builder()
                .id_branch(branchUpdate.getIdBranch())
                .code(branchUpdate.getCode())
                .address(branchUpdate.getAddress())
                .name(branchUpdate.getName())
                .build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        BranchBean branch = branchService.findById(id);
        branchService.delete(branch);
    }
}
