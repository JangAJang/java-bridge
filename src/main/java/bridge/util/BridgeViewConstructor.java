package bridge.util;

import java.util.List;

import static bridge.model.BridgeType.UPPER;

public class BridgeViewConstructor {

    private static final String RIGHT_BRIDGE = " O";
    private static final String BLANK_BRIDGE = "  ";
    private static final String WRONG_BRIDGE = " X";
    private static final String BRIDGE_CONNECTOR = " |";
    private static final String BRACKET_STARTED = "[";
    private static final String BRACKET_FINISHER = " ]";

    private StringBuilder upperBridge = new StringBuilder();
    private StringBuilder lowerBridge = new StringBuilder();

    public String constructBridge(List<String> player, List<String> bridge){
        constructBeforeLast(player);
        constructLast(player, bridge);
        return makeBracket();
    }

    private void constructBeforeLast(List<String> player){
        for(int bridgeEach = 0; bridgeEach < player.size()-1; bridgeEach++){
            appendRightAnswer(player.get(bridgeEach));
        }
    }

    private void constructLast(List<String> player, List<String> bridge){
        if(isSameLast(player, bridge)) {
            appendRightAnswer(getLastIndex(player));
            return;
        }
        appendWrongAnswer(getLastIndex(player));
    }

    private String getLastIndex(List<String> list){
        return list.get(list.size()-1);
    }

    private boolean isSameLast(List<String> player, List<String> bridge){
        return getLastIndex(player).equals(bridge.get(player.size()-1));
    }

    private void appendRightAnswer(String playerIndexed){
        if(isU(playerIndexed)){
            appendWithO(upperBridge);
            appendWithBlank(lowerBridge);
            return;
        }
        appendWithBlank(upperBridge);
        appendWithO(lowerBridge);
    }

    private void appendWrongAnswer(String playerIndexed){
        if(isU(playerIndexed)){
            appendWithX(upperBridge);
            appendWithBlank(lowerBridge);
            return;
        }
        appendWithBlank(upperBridge);
        appendWithX(lowerBridge);
    }

    private boolean isU(String playerIndexed){
        return playerIndexed.equals(UPPER.getCommand());
    }

    private void appendWithO(StringBuilder bridge){
        bridge.append(RIGHT_BRIDGE).append(BRIDGE_CONNECTOR);
    }

    private void appendWithBlank(StringBuilder bridge){
        bridge.append(BLANK_BRIDGE).append(BRIDGE_CONNECTOR);

    }

    private void appendWithX(StringBuilder bridge){
        bridge.append(WRONG_BRIDGE).append(BRIDGE_CONNECTOR);
    }

    private String makeBracket(){
        String upper = BRACKET_STARTED + deleteLastDivider(upperBridge) + BRACKET_FINISHER;
        String lower = BRACKET_STARTED + deleteLastDivider(lowerBridge) + BRACKET_FINISHER;
        return upper + "\n" + lower;
    }

    private String deleteLastDivider(StringBuilder stringBuilder){
        return stringBuilder.substring(0, stringBuilder.toString().length()-2);
    }
}
