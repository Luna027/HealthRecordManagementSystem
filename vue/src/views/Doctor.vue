<script>
export default {
  name: "Doctor",
  data() {
    return {
      tableData: [],
      total: 0,
      pageNum: 1,
      pageSize: 2,
      name: "",
      gender:"",
      department: "",
      position: "",
      phone:"",
      form: {},
      multipleSelection: [],
      dialogFormVisible: false,
    };
  },
  created() {
    this.load();
  },
  methods: {
    load() {
      this.request.get("/doctor/page", { // 修改3：将请求路径改为 /doctor/page
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
          name: this.name, // 修改4：将 username 改为 name
          department: this.department,
          position: this.position, // 修改5：将 address 改为 phone
        },
      }).then((res) => {
        console.log(res);
        this.tableData = res.records;
        this.total = res.total;
      });
    },

    save() {
      this.request.post("/doctor", this.form).then((res) => { // 修改6：将请求路径改为 /doctor
        if (res) {
          this.$message.success("保存成功");
          this.dialogFormVisible = false;
          this.load();
        } else {
          this.$message.error("保存失败");
        }
      });
    },
    cancel() {
      this.dialogFormVisible = false;
      this.load();
    },
    handleAdd() {
      this.dialogFormVisible = true;
      this.form = {};
    },
    handleEdit(row) {
      this.form = Object.assign({}, row);
      this.dialogFormVisible = true;
    },
    del(id) {
      this.request.delete("/doctor/" + id).then((res) => { // 修改7：将请求路径改为 /doctor
        if (res) {
          this.$message.success("删除成功");
          this.load();
        } else {
          this.$message.error("删除失败");
        }
      });
    },
    handleSelectionChange(val) {
      console.log(val);
      this.multipleSelection = val;
    },
    delBatch() {
      let ids = this.multipleSelection.map((v) => v.id);
      this.request.post("/doctor/del/batch", ids).then((res) => { // 修改8：将请求路径改为 /doctor/del/batch
        if (res) {
          this.$message.success("批量删除成功");
          this.load();
        } else {
          this.$message.error("批量删除失败");
        }
      });
    },
    reset() {
      this.name = ""; // 修改9：将 username 改为 name
      this.department = "";
      this.position = ""; // 修改10：将 address 改为 phone
      this.load();
    },
    handleSizeChange(pageSize) {
      console.log(pageSize);
      this.pageSize = pageSize;
      this.load();
    },
    handleCurrentChange(pageNum) {
      console.log(pageNum);
      this.pageNum = pageNum;
      this.load();
    },
  },
};
</script>

<template>
  <div>
    <div style="margin: 10px 0">
      <el-input
          style="width: 200px"
          placeholder="请输入医生姓名"
          suffix-icon="el-icon-search"
          v-model="name"
      ></el-input> <!-- 修改11：将 placeholder 和 v-model 改为医生相关 -->
      <el-input
          style="width: 200px"
          placeholder="请输入医生科室"
          suffix-icon="el-icon-search"
          class="ml-5"
          v-model="department"
      ></el-input>
      <el-input
          style="width: 200px"
          placeholder="请输入医生职位"
          suffix-icon="el-icon-search"
          class="ml-5"
          v-model="position"
      ></el-input>
      <el-button class="ml-5" type="primary" @click="load">搜索</el-button>
      <el-button type="warning" @click="reset">重置</el-button>
    </div>
    <div style="margin: 10px 0">
      <el-button type="primary" @click="handleAdd">新增医生<i class="el-icon-circle-plus-outline"></i></el-button>
      <el-popconfirm
          class="ml-5"
          confirm-button-text="确定"
          cancel-button-text="我再想想"
          icon="el-icon-info"
          icon-color="red"
          title="您确定批量删除吗？"
          @confirm="delBatch"
      >
        <el-button type="danger" slot="reference">批量删除<i class="el-icon-circle-remove-outline"></i></el-button>
      </el-popconfirm>
      <el-button type="primary" class="ml-5">导入<i class="el-icon-bottom"></i></el-button>
      <el-button type="primary">导出<i class="el-icon-top"></i></el-button>
    </div>

    <el-table :data="tableData" border stripe @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column prop="id" label="ID" width="80"></el-table-column>
      <el-table-column prop="name" label="医生姓名" width="80"></el-table-column>
      <el-table-column prop="gender" label="性别" width="60"></el-table-column>
      <el-table-column prop="age" label="年龄" width="60"></el-table-column>
      <el-table-column prop="department" label="科室" width="150"></el-table-column>
      <el-table-column prop="position" label="职位" width="150"></el-table-column>
      <el-table-column prop="phone" label="电话"width="150"></el-table-column>

      <el-table-column label="操作">
        <template v-slot:default="scope">
          <el-button type="success" @click="handleEdit(scope.row)">编辑<i class="el-icon-edit"></i></el-button>
          <el-popconfirm
              class="ml-5"
              confirm-button-text="确定"
              cancel-button-text="我再想想"
              icon="el-icon-info"
              icon-color="red"
              title="您确定删除吗？"
              @confirm="del(scope.row.id)"
          >
            <el-button type="danger" slot="reference">删除<i class="el-icon-remove-outline"></i></el-button>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>

    <div style="padding: 10px 0">
      <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="pageNum"
          :page-sizes="[2, 5, 10, 20]"
          :page-size="pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total"
      ></el-pagination>
    </div>

    <el-dialog title="医生信息" :visible.sync="dialogFormVisible" width="30%">
      <el-form label-width="70px" size="small">
        <el-form-item label="姓名">
          <el-input v-model="form.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="性别">
          <el-input v-model="form.gender" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="年龄">
          <el-input v-model="form.age" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="科室">
          <el-input v-model="form.department" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="职位">
          <el-input v-model="form.position" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="电话">
          <el-input v-model="form.phone" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancel">取 消</el-button>
        <el-button type="primary" @click="save">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<style scoped>
</style>