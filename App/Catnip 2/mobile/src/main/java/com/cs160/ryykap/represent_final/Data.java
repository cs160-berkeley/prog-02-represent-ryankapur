package com.cs160.ryykap.represent_final;

import java.util.HashMap;

/**
 * Created by ryykap on 3/4/16.
 */

public class Data {

    private HashMap<String,Rep> repHashMap = new HashMap<String, Rep>();

    public HashMap getHash() {
        return repHashMap;
    }

    Data(){
    }

    public void addRep (Rep r) {
        repHashMap.put(r.getName(), r);
    }

    public class Rep {

        private String _name;
        private String _party;
        private String _type;
        private String _enddate;
        private String _img_src;
        private String[] _bills;
        private String[] _committees;

        public Rep(){
            HashMap<String,Rep> _hash = repHashMap;
        }

        public Rep(String name, String party, String type, String enddate, String img, String[] bills, String[] committees) {
            _name = name;
            _party = party;
            _img_src = img;
            _bills = bills;
            _committees = committees;
            _type = type;
            _enddate = enddate;
        }

        public String getName() {
            return _name;
        }
        public String getParty() { return _party; }
        public String getType() { return _type; }
        public String getEndDate() { return _enddate; }
        public String getImgSrc() { return _img_src; }
        public String[] getBills() { return _bills; }
        public String[] getCommitties() { return _committees; }



        public void addRep (String name, String party, String type, String enddate, String img, String[] bills, String[] committees) {
            Rep r = new Rep(name, party, type, enddate, img, bills, committees);
            repHashMap.put(name, r);
        }


    }
}

