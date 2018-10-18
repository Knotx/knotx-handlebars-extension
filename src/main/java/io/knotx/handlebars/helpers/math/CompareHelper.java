/*
 * Copyright (C) 2018 Cognifide Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package io.knotx.handlebars.helpers.math;

import com.github.jknack.handlebars.Options;
import io.knotx.knot.templating.handlebars.CustomHandlebarsHelper;
import io.vertx.core.logging.Logger;
import java.io.IOException;
import java.util.function.Predicate;

abstract public class CompareHelper<T extends Comparable<T>> implements CustomHandlebarsHelper<T> {

  protected Object apply(T firstParam, Options options, Logger logger, Predicate<Integer> predicate)
      throws IOException {
    T secondParam = options.param(0);
    logger.debug("compareTo: {} vs {}", firstParam, secondParam);
    if ((firstParam == null) || (secondParam == null)) {
      return options.inverse();
    }
    return predicate.test(firstParam.compareTo(secondParam)) ? options.fn() : options.inverse();
  }

}
