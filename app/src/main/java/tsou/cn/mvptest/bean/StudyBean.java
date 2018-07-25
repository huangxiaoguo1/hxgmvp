package tsou.cn.mvptest.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/7/20 0020.
 */

public class StudyBean {

    /**
     * status : 100
     * showMessage : 操作成功
     * data : {"pager":{"currentPage":1,"totalPage":2,"totalRecord":27,"startRow":0,"pageSize":15},"list":[{"id":129,"title":"《产品积分体系搭建的方法和策略》","icon":"https://qingtian.1035.mobi/cmsPic/upload/mypic/20180521/large_1526876352652.png","tnames":"沈丹,朱军华","startdate":"2018-07-20 14:50:00","endline":"2018-07-18 10:00:00","hasjoin":3,"total":30,"isstop":1},{"id":132,"title":"weex 01课","icon":"https://qingtian.1035.mobi/cmsPic/upload/mypic/20180613/large_1528877073546.png","tnames":"黄孝果,陈欣欣  TS0935","startdate":"2018-07-17 10:50:00","endline":"2018-07-16 14:50:00","hasjoin":5,"total":15,"isstop":2},{"id":128,"title":"《向阿里学新零售》","icon":"https://qingtian.1035.mobi/cmsPic/upload/mypic/20180521/large_1526874260925.png","tnames":"徐全","startdate":"2018-05-24 13:30:00","endline":"2018-05-23 10:00:00","hasjoin":1,"total":30,"isstop":2},{"id":127,"title":"《消费升级下的新零售》","icon":"https://qingtian.1035.mobi/cmsPic/upload/mypic/20180515/large_1526380163918.png","tnames":"高雄勇","startdate":"2018-06-09 09:00:00","endline":"2018-06-01 00:00:00","hasjoin":5,"total":999,"isstop":2},{"id":126,"title":"《创造价值\u2014大数据下的\u201c互联网+\u201d业财融合》","icon":"https://qingtian.1035.mobi/cmsPic/upload/mypic/20180515/large_1526379897731.png","tnames":"左宾","startdate":"2018-06-08 09:00:00","endline":"2018-06-01 00:00:00","hasjoin":0,"total":999,"isstop":2},{"id":125,"title":"《问题分析与解决工作坊》","icon":"https://qingtian.1035.mobi/cmsPic/upload/mypic/20180515/large_1526379602080.png","tnames":"徐论衡","startdate":"2018-06-08 09:00:00","endline":"2018-06-01 00:00:00","hasjoin":0,"total":999,"isstop":2},{"id":124,"title":"《自信呈现与完美互动的五项修炼》 ","icon":"https://qingtian.1035.mobi/cmsPic/upload/mypic/20180515/large_1526379144627.png","tnames":"邱伟","startdate":"2018-06-08 09:00:00","endline":"2018-06-01 00:00:00","hasjoin":2,"total":999,"isstop":2},{"id":122,"title":"《创新营销与销售团队管理高级研修班》","icon":"https://qingtian.1035.mobi/cmsPic/upload/mypic/20180515/large_1526378481730.png","tnames":"鲍英凯","startdate":"2018-06-08 09:00:00","endline":"2018-06-01 00:00:00","hasjoin":0,"total":999,"isstop":2},{"id":121,"title":"《智慧母亲必修课--有效亲子沟通》","icon":"https://qingtian.1035.mobi/cmsPic/upload/mypic/20180515/large_1526378286803.png","tnames":"张慈恩","startdate":"2018-06-01 09:00:00","endline":"2018-06-01 00:00:00","hasjoin":2,"total":999,"isstop":2},{"id":120,"title":"《职场高效办公Office速成--Excel》","icon":"https://qingtian.1035.mobi/cmsPic/upload/mypic/20180515/large_1526377383629.png","tnames":"赵明哲","startdate":"2018-06-01 09:00:00","endline":"2018-06-01 00:00:00","hasjoin":0,"total":999,"isstop":2},{"id":119,"title":"《高效仓储物流与库存控制管理》","icon":"https://qingtian.1035.mobi/cmsPic/upload/mypic/20180515/large_1526376957216.png","tnames":"王国超","startdate":"2018-06-01 09:00:00","endline":"2018-06-01 00:00:00","hasjoin":0,"total":999,"isstop":2},{"id":118,"title":"《客户关系管理与渠道管理》","icon":"https://qingtian.1035.mobi/cmsPic/upload/mypic/20180515/large_1526376829065.png","tnames":"程广见","startdate":"2018-06-22 09:00:00","endline":"2018-06-01 00:00:00","hasjoin":4,"total":999,"isstop":2},{"id":117,"title":"《4D打造高绩效的完美团队》 ","icon":"https://qingtian.1035.mobi/cmsPic/upload/mypic/20180515/large_1526376742574.png","tnames":"苏进","startdate":"2018-06-01 09:00:00","endline":"2018-06-01 00:00:00","hasjoin":0,"total":999,"isstop":2},{"id":116,"title":"《职场高效办公Office速成--PPT精华版》","icon":"https://qingtian.1035.mobi/cmsPic/upload/mypic/20180515/large_1526376628726.png","tnames":"马建强","startdate":"2018-06-22 09:00:00","endline":"2018-06-01 00:00:00","hasjoin":2,"total":999,"isstop":2},{"id":115,"title":"《胜任力素质模型构建与应用》","icon":"https://qingtian.1035.mobi/cmsPic/upload/mypic/20180515/large_1526376313752.png","tnames":"邱明俊","startdate":"2018-06-01 09:00:00","endline":"2018-06-01 00:00:00","hasjoin":0,"total":999,"isstop":2}]}
     */

    private int status;
    private String showMessage;
    private DataBean data;

    @Override
    public String toString() {
        return "StudyBean{" +
                "status=" + status +
                ", showMessage='" + showMessage + '\'' +
                ", data=" + data +
                '}';
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getShowMessage() {
        return showMessage;
    }

    public void setShowMessage(String showMessage) {
        this.showMessage = showMessage;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * pager : {"currentPage":1,"totalPage":2,"totalRecord":27,"startRow":0,"pageSize":15}
         * list : [{"id":129,"title":"《产品积分体系搭建的方法和策略》","icon":"https://qingtian.1035.mobi/cmsPic/upload/mypic/20180521/large_1526876352652.png","tnames":"沈丹,朱军华","startdate":"2018-07-20 14:50:00","endline":"2018-07-18 10:00:00","hasjoin":3,"total":30,"isstop":1},{"id":132,"title":"weex 01课","icon":"https://qingtian.1035.mobi/cmsPic/upload/mypic/20180613/large_1528877073546.png","tnames":"黄孝果,陈欣欣  TS0935","startdate":"2018-07-17 10:50:00","endline":"2018-07-16 14:50:00","hasjoin":5,"total":15,"isstop":2},{"id":128,"title":"《向阿里学新零售》","icon":"https://qingtian.1035.mobi/cmsPic/upload/mypic/20180521/large_1526874260925.png","tnames":"徐全","startdate":"2018-05-24 13:30:00","endline":"2018-05-23 10:00:00","hasjoin":1,"total":30,"isstop":2},{"id":127,"title":"《消费升级下的新零售》","icon":"https://qingtian.1035.mobi/cmsPic/upload/mypic/20180515/large_1526380163918.png","tnames":"高雄勇","startdate":"2018-06-09 09:00:00","endline":"2018-06-01 00:00:00","hasjoin":5,"total":999,"isstop":2},{"id":126,"title":"《创造价值\u2014大数据下的\u201c互联网+\u201d业财融合》","icon":"https://qingtian.1035.mobi/cmsPic/upload/mypic/20180515/large_1526379897731.png","tnames":"左宾","startdate":"2018-06-08 09:00:00","endline":"2018-06-01 00:00:00","hasjoin":0,"total":999,"isstop":2},{"id":125,"title":"《问题分析与解决工作坊》","icon":"https://qingtian.1035.mobi/cmsPic/upload/mypic/20180515/large_1526379602080.png","tnames":"徐论衡","startdate":"2018-06-08 09:00:00","endline":"2018-06-01 00:00:00","hasjoin":0,"total":999,"isstop":2},{"id":124,"title":"《自信呈现与完美互动的五项修炼》 ","icon":"https://qingtian.1035.mobi/cmsPic/upload/mypic/20180515/large_1526379144627.png","tnames":"邱伟","startdate":"2018-06-08 09:00:00","endline":"2018-06-01 00:00:00","hasjoin":2,"total":999,"isstop":2},{"id":122,"title":"《创新营销与销售团队管理高级研修班》","icon":"https://qingtian.1035.mobi/cmsPic/upload/mypic/20180515/large_1526378481730.png","tnames":"鲍英凯","startdate":"2018-06-08 09:00:00","endline":"2018-06-01 00:00:00","hasjoin":0,"total":999,"isstop":2},{"id":121,"title":"《智慧母亲必修课--有效亲子沟通》","icon":"https://qingtian.1035.mobi/cmsPic/upload/mypic/20180515/large_1526378286803.png","tnames":"张慈恩","startdate":"2018-06-01 09:00:00","endline":"2018-06-01 00:00:00","hasjoin":2,"total":999,"isstop":2},{"id":120,"title":"《职场高效办公Office速成--Excel》","icon":"https://qingtian.1035.mobi/cmsPic/upload/mypic/20180515/large_1526377383629.png","tnames":"赵明哲","startdate":"2018-06-01 09:00:00","endline":"2018-06-01 00:00:00","hasjoin":0,"total":999,"isstop":2},{"id":119,"title":"《高效仓储物流与库存控制管理》","icon":"https://qingtian.1035.mobi/cmsPic/upload/mypic/20180515/large_1526376957216.png","tnames":"王国超","startdate":"2018-06-01 09:00:00","endline":"2018-06-01 00:00:00","hasjoin":0,"total":999,"isstop":2},{"id":118,"title":"《客户关系管理与渠道管理》","icon":"https://qingtian.1035.mobi/cmsPic/upload/mypic/20180515/large_1526376829065.png","tnames":"程广见","startdate":"2018-06-22 09:00:00","endline":"2018-06-01 00:00:00","hasjoin":4,"total":999,"isstop":2},{"id":117,"title":"《4D打造高绩效的完美团队》 ","icon":"https://qingtian.1035.mobi/cmsPic/upload/mypic/20180515/large_1526376742574.png","tnames":"苏进","startdate":"2018-06-01 09:00:00","endline":"2018-06-01 00:00:00","hasjoin":0,"total":999,"isstop":2},{"id":116,"title":"《职场高效办公Office速成--PPT精华版》","icon":"https://qingtian.1035.mobi/cmsPic/upload/mypic/20180515/large_1526376628726.png","tnames":"马建强","startdate":"2018-06-22 09:00:00","endline":"2018-06-01 00:00:00","hasjoin":2,"total":999,"isstop":2},{"id":115,"title":"《胜任力素质模型构建与应用》","icon":"https://qingtian.1035.mobi/cmsPic/upload/mypic/20180515/large_1526376313752.png","tnames":"邱明俊","startdate":"2018-06-01 09:00:00","endline":"2018-06-01 00:00:00","hasjoin":0,"total":999,"isstop":2}]
         */

        private PagerBean pager;
        private List<ListBean> list;

        @Override
        public String toString() {
            return "DataBean{" +
                    "pager=" + pager +
                    ", list=" + list +
                    '}';
        }

        public PagerBean getPager() {
            return pager;
        }

        public void setPager(PagerBean pager) {
            this.pager = pager;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class PagerBean {
            /**
             * currentPage : 1
             * totalPage : 2
             * totalRecord : 27
             * startRow : 0
             * pageSize : 15
             */

            private int currentPage;
            private int totalPage;
            private int totalRecord;
            private int startRow;
            private int pageSize;

            @Override
            public String toString() {
                return "PagerBean{" +
                        "currentPage=" + currentPage +
                        ", totalPage=" + totalPage +
                        ", totalRecord=" + totalRecord +
                        ", startRow=" + startRow +
                        ", pageSize=" + pageSize +
                        '}';
            }

            public int getCurrentPage() {
                return currentPage;
            }

            public void setCurrentPage(int currentPage) {
                this.currentPage = currentPage;
            }

            public int getTotalPage() {
                return totalPage;
            }

            public void setTotalPage(int totalPage) {
                this.totalPage = totalPage;
            }

            public int getTotalRecord() {
                return totalRecord;
            }

            public void setTotalRecord(int totalRecord) {
                this.totalRecord = totalRecord;
            }

            public int getStartRow() {
                return startRow;
            }

            public void setStartRow(int startRow) {
                this.startRow = startRow;
            }

            public int getPageSize() {
                return pageSize;
            }

            public void setPageSize(int pageSize) {
                this.pageSize = pageSize;
            }
        }

        public static class ListBean {
            /**
             * id : 129
             * title : 《产品积分体系搭建的方法和策略》
             * icon : https://qingtian.1035.mobi/cmsPic/upload/mypic/20180521/large_1526876352652.png
             * tnames : 沈丹,朱军华
             * startdate : 2018-07-20 14:50:00
             * endline : 2018-07-18 10:00:00
             * hasjoin : 3
             * total : 30
             * isstop : 1
             */

            private int id;
            private String title;
            private String icon;
            private String tnames;
            private String startdate;
            private String endline;
            private int hasjoin;
            private int total;
            private int isstop;

            @Override
            public String toString() {
                return "ListBean{" +
                        "id=" + id +
                        ", title='" + title + '\'' +
                        ", icon='" + icon + '\'' +
                        ", tnames='" + tnames + '\'' +
                        ", startdate='" + startdate + '\'' +
                        ", endline='" + endline + '\'' +
                        ", hasjoin=" + hasjoin +
                        ", total=" + total +
                        ", isstop=" + isstop +
                        '}';
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getTnames() {
                return tnames;
            }

            public void setTnames(String tnames) {
                this.tnames = tnames;
            }

            public String getStartdate() {
                return startdate;
            }

            public void setStartdate(String startdate) {
                this.startdate = startdate;
            }

            public String getEndline() {
                return endline;
            }

            public void setEndline(String endline) {
                this.endline = endline;
            }

            public int getHasjoin() {
                return hasjoin;
            }

            public void setHasjoin(int hasjoin) {
                this.hasjoin = hasjoin;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getIsstop() {
                return isstop;
            }

            public void setIsstop(int isstop) {
                this.isstop = isstop;
            }
        }
    }
}
