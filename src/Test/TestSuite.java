package Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import Test.Player.Test.GamePlayerTest;
import Test.Table.Test.GameTableTest;
import Test.PlayerState.Test.GamePlayerStateTest;
import org.junit.runners.Suite;
import org.junit.Test;
import org.junit.Assert;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        GameTableTest.class,
        GamePlayerTest.class,
        GamePlayerStateTest.class
})

public class TestSuite {
    // the class remains empty,
    // used only as a holder for the above annotations
}
