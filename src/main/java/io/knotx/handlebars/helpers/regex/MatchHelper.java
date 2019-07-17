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
import io.knotx.te.handlebars.CustomHandlebarsHelper;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Get i-th match of regex pattern (default entire first match).<br>
 * Usage:
 * <pre>
 *     {{match value pattern [index] [group]}}
 * </pre>
 */
public class MatchHelper implements CustomHandlebarsHelper<Object> {

  @Override
  public String getName() {
    return "match";
  }

  @Override
  public Object apply(Object context, Options options) throws IOException {
    if ((context != null) && (options.params.length > 0)) {
      Pattern pattern = Pattern.compile(options.param(0));
      Matcher matcher = pattern.matcher(context.toString());
      int start = options.params.length > 1 ? options.param(1) : 0;
      if (matcher.find(start)) {
        int group = options.params.length > 2 ? options.param(2) : 0;
        return matcher.group(group);
      }
    }
    return null;
  }

}
