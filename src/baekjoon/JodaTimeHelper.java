package baekjoon;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * @author 배근쓰
 */
public class JodaTimeHelper {

//    public static void main(String[] args) {
//
//        DateTime nowDt = DateTime.now();
//        String nowDate = nowDt.toString("yyyy-MM-dd");
//
//        List<DateTime[]> realList = emptySingleDayList(nowDate, "real");
//        List<DateTime[]> restList = emptySingleDayList(nowDate, "rest");
//        List<DateTime[]> applyList = emptySingleDayList(nowDate, "apply");
//
//        /* 인정시간 대역 1차  (실제 출/퇴근 & 신청 시간) */
//        DateTime[] rcognList = compareRcognJodaTime(realList.get(0), applyList.get(0));
//        assert rcognList != null;
//        System.out.println("1차 인정시간 대역 = " + rcognList[0].toString("yyyy-MM-dd HH:mm") + " / " + rcognList[1].toString("yyyy-MM-dd HH:mm"));
//
//        /* 1차 인정시간 대역에 휴게시간을 반영하여 최종 리스트를 뽑는다. */
//        List<DateTime[]> resultRcognList = makeRcognJodaTimeList(rcognList, restList);
//        resultRcognList = sortAscDateTimeArrays(resultRcognList);
//
//        /* 1차 인정시간 대역과  */
//        GenericHelper<List<DateTime[]>> test = new GenericHelper<>(resultRcognList, "joda");
//        printObj(test.getData());
//    }

    public static List<DateTime[]> emptySingleDayList (String defaultDate, String type){

        List<DateTime[]> returnList = new ArrayList<>();

        String [] defaultSplit = defaultDate.split("-");
        /*
         * 0번째는 시작
         * 1번째는 종료
         * */
        DateTime [] firstTmp = new DateTime [2];
        DateTime [] secondTmp = new DateTime[2];
        DateTime [] thirdTmp = new DateTime[2];
        DateTime [] fourthTmp = new DateTime[2];

        Date ddd = new Date();
        System.out.println(ddd.getTime());

        if("rest".equals(type)){

            firstTmp[0] = new DateTime(stringToInt(defaultSplit[0]), stringToInt(defaultSplit[1]), stringToInt(defaultSplit[2]), 18, 0);
            firstTmp[1] = new DateTime(stringToInt(defaultSplit[0]), stringToInt(defaultSplit[1]), stringToInt(defaultSplit[2]), 20, 0);

//            secondTmp[0] = new DateTime(stringToInt(defaultSplit[0]),stringToInt(defaultSplit[1]),stringToInt(defaultSplit[2]),9,0);
//            secondTmp[1] = new DateTime(stringToInt(defaultSplit[0]),stringToInt(defaultSplit[1]),stringToInt(defaultSplit[2]),12,0);

//            thirdTmp[0] = new DateTime(stringToInt(defaultSplit[0]),stringToInt(defaultSplit[1]),stringToInt(defaultSplit[2]),12,0);
//            thirdTmp[1] = new DateTime(stringToInt(defaultSplit[0]),stringToInt(defaultSplit[1]),stringToInt(defaultSplit[2]),15,0);


//            fourthTmp[0] = new DateTime(stringToInt(defaultSplit[0]),stringToInt(defaultSplit[1]),stringToInt(defaultSplit[2]),17,0);
//            fourthTmp[1] = new DateTime(stringToInt(defaultSplit[0]),stringToInt(defaultSplit[1]),stringToInt(defaultSplit[2]),18,0);


            returnList.add(firstTmp);
//            returnList.add(thirdTmp);
//            returnList.add(secondTmp);
//            returnList.add(fourthTmp);

        }else if("apply".equals(type)){

            firstTmp[0] = new DateTime(stringToInt(defaultSplit[0]), stringToInt(defaultSplit[1]), stringToInt(defaultSplit[2]), 9, 0);
            firstTmp[1] = new DateTime(stringToInt(defaultSplit[0]), stringToInt(defaultSplit[1]), stringToInt(defaultSplit[2]), 19, 0);

            returnList.add(firstTmp);

        }else{

            firstTmp[0] = new DateTime(stringToInt(defaultSplit[0]), stringToInt(defaultSplit[1]), stringToInt(defaultSplit[2]), 9, 0);
            firstTmp[1] = new DateTime(stringToInt(defaultSplit[0]), stringToInt(defaultSplit[1]), stringToInt(defaultSplit[2]), 23, 10);

            returnList.add(firstTmp);

        }

        return returnList;
    }

    private static int stringToInt(String value){
//		return	Integer.valueOf(value);
        return Integer.parseInt(value);
    }

    /**
     * yyyy-MM-dd HH:mm String을 받아 dateTime으로 변환
     *
     * @param day - yyyy-MM-dd
     * @param time - HH:mm
     * @return
     */
    public static DateTime convertJodaDateTime(String day, String time){

        DateTime returnDateTime = null;

        String [] daySplit = day.split("-");
        String [] timeSplit = time.split(":");

        // 초단위는 무시하자 (올림이나 내림으로해서 하는 부분을 만들 것)
        int year = stringToInt(daySplit[0]);
        int month = stringToInt(daySplit[1]);
        int days = stringToInt(daySplit[2]);
        int hour = stringToInt(timeSplit[0]);
        int min = stringToInt(timeSplit[1]);
//		int ss = stringToInt(timeSplit[2]);

        if(hour >= 24){
            hour -= 24;
            returnDateTime = new DateTime(year, month, days, hour, min);
            returnDateTime = returnDateTime.plusDays(1);
        }else{
            returnDateTime = new DateTime(year, month, days, hour, min);
        }

        return returnDateTime;
    }

    /**
     *
     * 실제 출퇴근 dateTime과 신청 dateTime을 비교하여
     * 인정 DateTime을 만든다.
     *
     * @param first
     * @param second
     * @return DateTime[]
     */
    public static DateTime[] compareRcognJodaTime(DateTime[] first, DateTime[] second){

        DateTime[] returnDateTime = new DateTime[2];

        DateTime [] real = first.clone();
        DateTime [] apply = second.clone();

        // real은 null 또는 인정처리 가 있을 수 있다.


        /*
         *
         *  A.compareTo(B) == -1  / A가 더 작다. (시간이 더 빠르다.)
         *  A.compareTo(B) == 0	/ A, B가 같다. (시간이 같다.)
         *  A.compareTo(B) == 1	/ A가 더 크다. (시간이 더 늦다.)
         *
         * */
        DateTime stTime = null;
        DateTime edTime = null;
        if(real[0].compareTo(apply[0]) >= 0){

            if(real[0].compareTo(apply[1]) <= 0){

                if(real[1].compareTo(apply[1]) <= 0){
                    stTime = real[0];
                    edTime = real[1];
                }else{
                    stTime = real[0];
                    edTime = apply[1];
                }
            }

        }else{

            stTime = apply[0];

            if(real[1].compareTo(apply[1]) >= 0){
                edTime = apply[1];
            }else{
                edTime = real[1];
            }

        }

        if(stTime == null || edTime == null){
            return null;
        }else{
            returnDateTime[0] = stTime;
            returnDateTime[1] = edTime;
        }

        return returnDateTime;
    }

    /**
     * 최종인정시간 대역 만들기
     * 
     * @param rcognTime
     * @param minusList
     * @return
     */
    public static List<DateTime[]> makeRcognJodaTimeList(DateTime[] rcognTime, List<DateTime[]> minusList){

        List<DateTime[]> returnList = new ArrayList<>();

        if(rcognTime == null){
            System.out.println("인정시간이 null");
            return null;
        }

        DateTime[] copyRcognTime = rcognTime.clone();
        List<DateTime[]> copyMinusList = copyObjectJodaList(minusList);
        copyMinusList = sortAscDateTimeArrays(copyMinusList);

        /* 1번 작업 - 1차 인정시간에 걸치지 않는 대역 제외하는 작업 진행 */
//        int loopSize = copyMinusList.size();
        DateTime baseStTime = copyRcognTime[0];
        DateTime baseEdTime = copyRcognTime[1];

        List<DateTime[]> arrangeMinusList = new ArrayList<>();
        for(DateTime[] vo : copyMinusList){

            DateTime loopSt = vo[0];
            DateTime loopEd = vo[1];

            boolean isSt = baseStTime.compareTo(loopSt) < 0 && baseEdTime.compareTo(loopSt) > 0;
            boolean isEd = baseStTime.compareTo(loopEd) < 0 && baseEdTime.compareTo(loopEd) > 0;

            if(isSt || isEd){
                arrangeMinusList.add(vo);
            }

        }

        /* 최종 리스트 생성 작업 진행 */
        int loopSize = arrangeMinusList.size();
        if(loopSize == 0){

            DateTime[] tmp = new DateTime[2];
            tmp[0] = baseStTime;
            tmp[1] = baseEdTime;

            returnList.add(tmp);

        }else{

            if(loopSize == 1){

                DateTime[] loopDateTime = arrangeMinusList.get(0);
                DateTime loopSt = loopDateTime[0];
                DateTime loopEd = loopDateTime[1];

                DateTime[] firstTmp = new DateTime[2];
                DateTime[] secondTmp = new DateTime[2];

                if(loopSt.compareTo(baseStTime) > 0){

                    firstTmp[0] = baseStTime;

                    if(loopEd.compareTo(baseEdTime) < 0){

                        firstTmp[1] = loopSt;
                        secondTmp[0] = loopEd;
                        secondTmp[1] = baseEdTime;

                        returnList.add(firstTmp);
                        returnList.add(secondTmp);
                    }else{

                        firstTmp[1] = loopSt;

                        returnList.add(firstTmp);
                    }

                }else{
                    firstTmp[0] = loopEd;
                    firstTmp[1] = baseEdTime;

                    returnList.add(firstTmp);
                }

            }else{

            }
//            for(int i = 0; i < loopSize; i++){
//
//            }

        }


        return returnList;
    }

    /**
     * DateTime[] List를 ASC 정렬한다.
     *
     * @param sortList
     * @return
     */
    public static List<DateTime> sortAscDateTime (List<DateTime> sortList){

        if(sortList == null){
            return null;
        }

        sortList.sort(new Comparator<DateTime>() {
            @Override
            public int compare(DateTime first, DateTime second) {

                return first.compareTo(second);
            }
        });

        return sortList;
    }

    public static List<DateTime []> sortAscDateTimeArrays (List<DateTime[]> sortList){

        if(sortList == null){
            return null;
        }

        List<DateTime []> copyList = copyObjectJodaList(sortList);

        copyList.sort(new Comparator<DateTime[]>() {
            @Override
            public int compare(DateTime[] first, DateTime[] second) {

                return first[0].compareTo(second[0]);
            }
        });

        return copyList;
    }

    /**
     * DateTime List Object를 복사한다.
     *
     * @param list
     * @return
     */
    public static List<DateTime[] > copyObjectJodaList (List<DateTime[]> list){

        if(list == null){
            return null;
        }

        List<DateTime[]> returnList = new ArrayList<>();

        for(DateTime [] vo : list ){
            returnList.add(vo.clone());
        }

        return returnList;

    }


    /**
     *
     * 월의 시작일 또는 종료일
     * 주의 시작일 또는 종료일
     * yyyy-MM-dd format으로 리턴
     *
     * 주는 월/화/수/목/금/토/일 시작 요일 선택 가능
     *
     * jodaTime은 ISO 기반의 월요일이 기준이다.
     *
     * 1 == 월 / 7 == 일
     *
     * @param dt
     * @param dateType
     * @param stOrEd
     * @param option
     * @return
     */
    public static String jodaStartEndDate (DateTime dt, String dateType, String stOrEd, String option){

        DateTime copyDt = dt;
        String returnDateTime = null;

        if("month".equals(dateType)){
            // 사실상 2월 윤달 때문에 만들었다...
            switch (stOrEd){
                case "start" :
                    copyDt = copyDt.dayOfMonth().withMinimumValue();
                    break;
                case "end" :
                    copyDt = copyDt.dayOfMonth().withMaximumValue();
                    break;
            }

        }else{
            /*
             * joda 타임은 ISO 기반의 월요일 시작이 기본이다.
             * 월요일 제외하고 모든 요일은 일요일일때 추가 계산식을 넣어줘야한다.
             *
             * */
            int weekDay = Integer.parseInt(copyDt.toString("e"));

            int conVal = 0;
            switch (option){
                case "MON":
                    conVal = DateTimeConstants.MONDAY;
                    break;
                case "TUE":
                    conVal = DateTimeConstants.TUESDAY;
                    break;
                case "WED":
                    conVal = DateTimeConstants.WEDNESDAY;
                    break;
                case "THU":
                    conVal = DateTimeConstants.THURSDAY;
                    break;
                case "FRI":
                    conVal = DateTimeConstants.FRIDAY;
                    break;
                case "SAT":
                    conVal = DateTimeConstants.SATURDAY;
                    break;
                case "SUN":
                    conVal = DateTimeConstants.SUNDAY;
                    break;
            }

            if(conVal == 1){
                if("start".equals(stOrEd)){
                    copyDt = copyDt.dayOfWeek().withMinimumValue();
                }else{
                    copyDt = copyDt.dayOfWeek().withMaximumValue();
                }
            }else{
                if("start".equals(stOrEd)){
                    if(weekDay < conVal){
                        copyDt = copyDt.withDayOfWeek(conVal).minusDays(7);
                    }else{
                        copyDt = copyDt.withDayOfWeek(conVal);
                    }
                }else{
                    if(weekDay < conVal) {
                        copyDt = copyDt.withDayOfWeek(conVal).minusDays(1);
                    }else {
                        copyDt = copyDt.withDayOfWeek(conVal).plusDays(6);
                    }
                }
            }

        }
        returnDateTime = copyDt.toString("yyyy-MM-dd");

        return returnDateTime;
    }


    public static void printObj(List<DateTime[]> list){

        System.out.println("----------------------------------");

        if(list == null){
            return;
        }

        for(DateTime[] vo : list){
            System.out.println(vo[0].toString("yyyy-MM-dd HH:mm") + " : " + vo[1].toString("yyyy-MM-dd HH:mm"));
        }

    }

}
