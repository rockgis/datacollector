/**
 * Copyright 2017 StreamSets Inc.
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
package com.streamsets.pipeline.stage.origin.jms;

import com.streamsets.pipeline.api.ConfigDef;
import com.streamsets.pipeline.api.ValueChooserModel;
import com.streamsets.pipeline.lib.jms.config.BaseJmsConfig;

public class JmsSourceConfig extends BaseJmsConfig {
  @ConfigDef(
      required = true,
      type = ConfigDef.Type.STRING,
      label = "JMS Destination Name",
      description = "Queue or topic name",
      displayPosition = 50,
      group = "JMS"
  )
  public String destinationName;

  @ConfigDef(
    required = false,
    type = ConfigDef.Type.STRING,
    label = "JMS Message Selector",
    displayPosition = 60,
    group = "JMS"
  )
  public String messageSelector;

  @ConfigDef(
    required = false,
    type = ConfigDef.Type.MODEL,
    defaultValue = "UNKNOWN",
    label = "JMS Destination Type",
    description = "Specify the JMS destination type when validation fails with NamingException, destination not found",
    displayPosition = 70,
    group = "JMS"
  )
  @ValueChooserModel(DestinationTypeChooserValues.class)
  public DestinationType destinationType = DestinationType.UNKNOWN; // NOTE: same as above
}
