package in.arpaul.androicomponents.fragments.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.arpaul.androicomponents.models.UserDO;

public class DummyContent {

    public static final List<UserDO> ITEMS = new ArrayList<UserDO>();

    public static final Map<String, UserDO> ITEM_MAP = new HashMap<String, UserDO>();

    private static final int COUNT = 25;

    static {
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(UserDO item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static UserDO createDummyItem(int position) {
        UserDO objUser = new UserDO();
        objUser.id = "" + position;
        objUser.fName = "Aritra";
        objUser.lName = "Pal " + position;
        return objUser;
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }
}
