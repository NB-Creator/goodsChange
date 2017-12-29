$(function () {
    
        // 1.初始化Table
        var oTable = new TableInit();
        oTable.Init();
    
        // 2.初始化Button的点击事件
        var oButtonInit = new ButtonInit();
        oButtonInit.Init();
    
    });
    
    (function (i, s, o, g, r, a, m) {
        i['GoogleAnalyticsObject'] = r;
        i[r] = i[r] || function () {
            (i[r].q = i[r].q || []).push(arguments)
        }, i[r].l = 1 * new Date();
        a = s.createElement(o), m = s.getElementsByTagName(o)[0];
        a.async = 1;
        a.src = g;
        m.parentNode.insertBefore(a, m)
    })(window, document, 'script', '//www.google-analytics.com/analytics.js', 'ga');
    ga('create', 'UA-36708951-1', '');
    ga('send', 'pageview');
    
    var TableInit = function () {
        var oTableInit = new Object();
        // 初始化Table
        oTableInit.Init = function () {
            $('#tb_departments').bootstrapTable({
                url: '/data.json', // 请求后台的URL（*）
                method: 'post', // 请求方式（*）post/get
                toolbar: '#toolbar', // 工具按钮用哪个容器
                striped: true, // 是否显示行间隔色
                cache: false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                pagination: true, // 是否显示分页（*）
                sortable: false, // 是否启用排序
                sortOrder: "asc", // 排序方式
                queryParams: oTableInit.queryParams, // 传递参数（*）
                sidePagination: "client", // 分页方式：client客户端分页，server服务端分页（*）
                pageNumber: 1, // 初始化加载第一页，默认第一页
                pageSize: 5, // 每页的记录行数（*）
                pageList: [5, 10, 15, 20], // 可供选择的每页的行数（*）
                search: false, // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
                strictSearch: true,
                showColumns: false, // 是否显示所有的列
                showRefresh: false, // 是否显示刷新按钮
                minimumCountColumns: 2, // 最少允许的列数
                clickToSelect: true, // 是否启用点击选中行
                height: "", // 行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                uniqueId: "ID", // 每一行的唯一标识，一般为主键列
                showToggle: false, // 是否显示详细视图和列表视图的切换按钮
                cardView: false, // 是否显示详细视图
                detailView: false, // 是否显示父子表
                locale: "zh-CN", //中文支持
                columns: [{
                        checkbox: true
                    },
                    {
                        field: 'title',
                        title: '商品信息'
                    }, {
                        field: 'type',
                        title: '商铺'
                    },
                    {
                        field: 'money',
                        title: '商品价格'
                    },
                    {
                        field: 'number',
                        title: '数量'
                    },
                    {
                        field: 'money1',
                        title: '金额'
                    },
                    {
                        field: 'action',
                        title: '操作',
                        formatter: //对本列数据做格式化
                            function (value, row, index) { //赋予的参数
                                return [
                                    '<botton> 移入收藏夹</botton>',
                                    '<botton> 删除</botton>',
                                    '<botton> 付款</botton>',
                                ].join('');
                            }
                    }
                ]
            });
        };
    
        // 得到查询的参数
        oTableInit.queryParams = function (params) {
            var temp = { // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                limit: params.limit, // 页面大小
                offset: params.offset, // 页码
            };
            return temp;
        };
        return oTableInit;
    };
    
    var ButtonInit = function () {
        var oInit = new Object();
        var postdata = {};
    
        oInit.Init = function () {
        };
        return oInit;
    };