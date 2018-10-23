/*
 * Copyright (C) 2018 Cognifide Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.knotx.handlebars.helpers.math;

import com.github.jknack.handlebars.Options;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import java.io.IOException;

/**
 * Checks if value1 is smaller or equal to value2.<br>
 * Usage:
 * <pre>
 *     {{#le value1 value2}}
 *          smaller or equal
 *     {{else}}
 *         greater
 *     {{/le}}
 * </pre>
 */
public class LessEqualHelper<T extends Comparable<T>> extends CompareHelper<T> {

  private static final Logger LOGGER = LoggerFactory.getLogger(LessEqualHelper.class);

  @Override
  public String getName() {
    return "le";
  }

  @Override
  public Object apply(T firstParam, Options options) throws IOException {
    return super.apply(firstParam, options, LOGGER, i -> i <= 0);
  }
}
