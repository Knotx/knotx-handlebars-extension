/*
 * Copyright (C) 2018 Knot.x Project
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
package io.knotx.handlebars.helpers.regex;

import com.github.jknack.handlebars.Options;
import com.github.jknack.handlebars.helper.EachHelper;
import io.knotx.te.handlebars.CustomHandlebarsHelper;
import java.io.IOException;
import java.util.Arrays;

/**
 * Iterates over a split string.<br>
 * Usage:
 * <pre>
 *     {{each-split value delimiter_pattern}}
 * </pre>
 * 
 * @see com.github.jknack.handlebars.helper.EachHelper
 */
public class EachSplitHelper extends EachHelper implements CustomHandlebarsHelper<Object> {

  @Override
  public String getName() {
    return "each-split";
  }

  @Override
  public Object apply(Object context, Options options) throws IOException {
    if ((context != null) && (options.params.length > 0)) {
      String delimiter = options.param(0);
      return super.apply(Arrays.asList(context.toString().split(delimiter)), options);
    }
    return null;
  }

}
