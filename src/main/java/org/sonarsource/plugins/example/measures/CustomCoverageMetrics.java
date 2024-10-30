/**
 * defines the metric
 */


package org.sonarsource.plugins.example.measures;

import java.util.List;
import org.sonar.api.measures.CoreMetrics;
import org.sonar.api.measures.Metric;
import org.sonar.api.measures.Metrics;

import static java.util.Arrays.asList;

public class CustomCoverageMetrics implements Metrics {

    public static final Metric<Integer> CUSTOM_TEST_SUCCESS = new Metric.Builder("custom_test_success", "Custom Test Success", Metric.ValueType.PERCENT)
      .setDescription("Custom test_success_density")
      .setDirection(Metric.DIRECTION_BETTER)
      .setQualitative(false)
      .setDomain(CoreMetrics.DOMAIN_COVERAGE)
      .create();

    public static final Metric<Integer> CUSTOM_COVERAGE = new Metric.Builder("custom_coverage", "Custom Coverage", Metric.ValueType.INT)
      .setDescription("Custom coverage")
      .setDirection(Metric.DIRECTION_BETTER)
      .setQualitative(false)
      .setDomain(CoreMetrics.DOMAIN_COVERAGE)
      .create();

    public static final Metric<Integer> CUSTOM_NEW_COVERAGE = new Metric.Builder("custom_new_coverage", "Custom New Coverage", Metric.ValueType.INT)
      .setDescription("Custom new_coverage")
      .setDirection(Metric.DIRECTION_BETTER)
      .setQualitative(false)
      .setDomain(CoreMetrics.DOMAIN_COVERAGE)
      .create();

    @Override
    public List<Metric> getMetrics() {
      return asList(CUSTOM_TEST_SUCCESS, CUSTOM_COVERAGE, CUSTOM_NEW_COVERAGE);
    }
}
