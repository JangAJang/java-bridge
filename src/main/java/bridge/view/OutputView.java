package bridge.view;
public class OutputView {

    private static final String TOTAL_RESULT = "최종 게임 결과";
    private static final String SUCCESS_RESULT = "게임 성공 여부: ";
    private static final String TOTAL_TRIAL = "총 시도한 횟수: ";
    private static final String SUCCESS = "성공";
    private static final String FAILURE = "실패";
    private static final String PROOF_OF_FAIL = "X";

    public void printMap() {
    }
    public void printResult(String result, int trialCount) {
    }

    private boolean isFail(String result){
        return result.contains(PROOF_OF_FAIL);
    }

    private void printGameStatus(){

    }

    private void printTrialCounts(){

    }
}
