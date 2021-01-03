package config;

import model.searchModel.searchStrategies.ContentsHashStrategy;
import model.searchModel.searchStrategies.ISearchStrategy;
import model.searchModel.searchStrategies.MetadataHashStrategy;
import util.Logger;

import java.util.Arrays;
import java.util.List;

/**
 * Program configuration constants
 */
public class Config {

    /* General */
    public static final Logger.Level LOG_LEVEL = Logger.Level.DEBUG;

    /* Model */
    public static final List<String> SUPPORTED_FILE_TYPES = Arrays.asList("JPEG", "JPG", "PNG");
    public static final Integer POOL_SIZE = 3;

    /* UI */
    public static final double SCENE_WIDTH = 1536;
    public static final double SCENE_HEIGHT = 864;

    public static final double STAGE_MIN_WIDTH = 400;
    public static final double STAGE_MIN_HEIGHT = 400;
    public static final String STAGE_TITLE = "Duplicate Detector";

    public static final int PRE_SCAN_WAIT_POLL_INTERVAL_MS = 100;
    public static final int PRE_SCAN_WAIT_TIMEOUT_MS = 2000;
    public static final int PRE_SCAN_POLL_INTERVAL_MS = 100;
    public static final long PRE_SCAN_TIMEOUT_MS = Long.MAX_VALUE;

    /**
     * Details of a search strategy to show on the UI
     */
    public static final class SearchStrategyDescription {

        private final Class<? extends ISearchStrategy> strategy;
        private final String uiName;
        private final String desc;

        SearchStrategyDescription(Class<? extends ISearchStrategy> strategy, String uiName, String desc) {
            this.strategy = strategy;
            this.uiName = uiName;
            this.desc = desc;
        }

        public Class<? extends ISearchStrategy> getStrategy() {
            return strategy;
        }

        public String getUiName() {
            return uiName;
        }

        public String getDesc() {
            return desc;
        }

    }

    /* File Paths */
    private static final String PATH_TO_VIEW_FROM_FXML_UTILS = "view";
    public static final String PARENT_FRAME = PATH_TO_VIEW_FROM_FXML_UTILS + "/layouts/ParentFrame.fxml";
    public static final String DARK_THEME_CSS = "style/darkTheme.css";
    public static final String LAYOUTS_CONFIGURE_SCAN_FXML = PATH_TO_VIEW_FROM_FXML_UTILS + "/layouts/ConfigureScan.fxml";
    public static final String LAYOUTS_PREPARE_TO_SCAN_FXML = PATH_TO_VIEW_FROM_FXML_UTILS + "/layouts/PrepareToScan.fxml";
    public static final String LAYOUTS_NEW_SCAN_FXML = PATH_TO_VIEW_FROM_FXML_UTILS + "/layouts/NewScan.fxml";
    public static final String LAYOUTS_RUN_SCAN_FXML = PATH_TO_VIEW_FROM_FXML_UTILS + "/layouts/RunScan.fxml";
    public static final String LAYOUTS_RESULTS_FXML = PATH_TO_VIEW_FROM_FXML_UTILS + "/layouts/Results.fxml";
    
    /* Search Strategies */
    public static final SearchStrategyDescription quick = new SearchStrategyDescription(MetadataHashStrategy.class,
            "Quick Scan", "Finds photos with the same name and size.");
    public static final SearchStrategyDescription full = new SearchStrategyDescription(ContentsHashStrategy.class,
            "Full Scan", "Finds photos with the same contents.");
}
