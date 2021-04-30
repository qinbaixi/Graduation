package cn.qut.graduation.controller;

import cn.qut.graduation.pojo.HCommit;
import cn.qut.graduation.pojo.IdExtension;
import cn.qut.graduation.service.HCommitService;
import cn.qut.graduation.service.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("hcommit")
public class HCommitController {
    @Autowired
    private HCommitService hCommitService;

    @GetMapping("getById/{sid}")
    public ResponseEntity<List<HCommit>> getById(@PathVariable(name = "sid", required = false) Integer id) {

        List<HCommit> hCommitList = hCommitService.getAllBySid(id);
        return ResponseEntity.ok(hCommitList);
    }

    /**
     *更新hcommit表
     * @param branch 学号加作业id 形如2017065261
     * @param rpAddr 测试报告地址
     * @return
     */
    @PostMapping("update")
    public ResponseEntity<Boolean> updateBranchAndReport(@RequestParam(name = "branch")Integer branch,
                                                         @RequestParam(name = "rpAddr") String rpAddr) {
        Boolean flag = this.hCommitService.updateBranchAndReport(branch, rpAddr);
        return ResponseEntity.ok(flag);
    }

}
