package TestsSuites;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages("TestsCases")
@IncludeTags("regressao")
public class RegressionTest {
}

