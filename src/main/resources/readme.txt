请求json格式
http://localhost:8080/user/page/single-table
{
    "pageNavigation": {
        "pageNum": 1,
        "pageSize": 2
    },
    "pageCondition": {
        "map": {
            "userName": "长草"
        }
    }
}

多条件分页  "userName": "张"不传会产生笛卡尔积
{
    "pageNavigation": {
        "pageNum": 1,
        "pageSize": 3
    },
    "pageCondition": {
        "map": {
            "userName": "张"
        }
    }
}