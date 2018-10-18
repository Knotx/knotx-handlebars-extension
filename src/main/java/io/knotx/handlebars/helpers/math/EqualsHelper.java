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
import io.knotx.knot.templating.handlebars.CustomHandlebarsHelper;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import java.io.IOException;

/**
 * Checks if value1 and value2 are equal.<br> Usage:
 * <pre>
 *     {{#eq value1 value2}}
 *         equal
 *     {{else}}
 *         not equal
 *     {{/eq}}
 * </pre>
 */
public class EqualsHelper implements CustomHandlebarsHelper<Object> {

  private static final Logger LOGGER = LoggerFactory.getLogger(EqualsHelper.class);

  @Override
  public String getName() {
    return "eq";
  }

  @Override
  public Object apply(Object firstParam, Options options) throws IOException {
    Object secondParam = options.param(0);
    LOGGER.debug("compareTo: {} vs {}", firstParam, secondParam);
    if (firstParam == null) {
      return options.inverse();
    }
    return firstParam.equals(secondParam) ? options.fn() : options.inverse();
  }
}
