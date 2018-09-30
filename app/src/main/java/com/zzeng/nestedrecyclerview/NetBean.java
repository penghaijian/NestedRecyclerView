package com.zzeng.nestedrecyclerview;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者: zengxc
 * 描述:
 * 时间: 2018/09/30 14:33
 */

public class NetBean {

    /**
     * data : [{"name":"A","id":"1201","child":[{"name":"A1","id":"120101"},{"name":"A2","id":"120102"},{"name":"A3","id":"120103"},{"name":"A4","id":"120104"},{"name":"A5","id":"120105"}]},{"name":"B","id":"1202","child":[{"name":"B1","id":"120201"},{"name":"B2","id":"120202"},{"name":"B3","id":"120203"}]},{"name":"C","id":"1001203","child":[{"name":"C1","id":"120301"},{"name":"C2","id":"120302"},{"name":"C3","id":"120303"},{"name":"C4","id":"120304"},{"name":"C5","id":"120305"},{"name":"C6","id":"120306"}]},{"name":"D","id":"1001204","child":[{"name":"D1","id":"120401"},{"name":"D2","id":"120402"},{"name":"D3","id":"120403"},{"name":"D4","id":"120404"},{"name":"D5","id":"120405"}]},{"name":"E","id":"1001205","child":[{"name":"E1","id":"120501"},{"name":"E2","id":"120502"},{"name":"E3","id":"120503"},{"name":"E4","id":"120504"},{"name":"E5","id":"120505"},{"name":"E6","id":"120506"},{"name":"E7","id":"120507"}]}]
     * responseCode : 0000
     * isSuccess : true
     * responseMsg : ok
     */

    private String responseCode;
    private boolean isSuccess;
    private String responseMsg;
    private List<DataBean> data;

    public String getResponseCode() {
        return responseCode == null ? "" : responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getResponseMsg() {
        return responseMsg == null ? "" : responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public List<DataBean> getData() {
        if (data == null) {
            return new ArrayList<>();
        }
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * name : A
         * id : 1201
         * child : [{"name":"A1","id":"120101"},{"name":"A2","id":"120102"},{"name":"A3","id":"120103"},{"name":"A4","id":"120104"},{"name":"A5","id":"120105"}]
         */

        private String name;
        private String id;
        private List<ChildBean> child;

        public String getName() {
            return name == null ? "" : name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id == null ? "" : id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<ChildBean> getChild() {
            if (child == null) {
                return new ArrayList<>();
            }
            return child;
        }

        public void setChild(List<ChildBean> child) {
            this.child = child;
        }

        public static class ChildBean {
            /**
             * name : A1
             * id : 120101
             */

            private String name;
            private int id;

            public String getName() {
                return name == null ? "" : name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getId() {
                return id ;
            }

            public void setId(int id) {
                this.id = id;
            }
        }
    }
}
