package com.qeagle.devtools.protocol.commands;

/*-
 * #%L
 * cdt-java-client
 * %%
 * Copyright (C) 2018 - 2019 TL
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.qeagle.devtools.protocol.events.applicationcache.ApplicationCacheStatusUpdated;
import com.qeagle.devtools.protocol.events.applicationcache.NetworkStateUpdated;
import com.qeagle.devtools.protocol.support.annotations.EventName;
import com.qeagle.devtools.protocol.support.annotations.Experimental;
import com.qeagle.devtools.protocol.support.annotations.ParamName;
import com.qeagle.devtools.protocol.support.annotations.ReturnTypeParameter;
import com.qeagle.devtools.protocol.support.annotations.Returns;
import com.qeagle.devtools.protocol.support.types.EventHandler;
import com.qeagle.devtools.protocol.support.types.EventListener;
import com.qeagle.devtools.protocol.types.applicationcache.FrameWithManifest;
import java.util.List;

@Experimental
public interface ApplicationCache {

  /** Enables application cache domain notifications. */
  void enable();

  /**
   * Returns relevant application cache data for the document in given frame.
   *
   * @param frameId Identifier of the frame containing document whose application cache is
   *     retrieved.
   */
  @Returns("applicationCache")
  com.qeagle.devtools.protocol.types.applicationcache.ApplicationCache
      getApplicationCacheForFrame(@ParamName("frameId") String frameId);

  /**
   * Returns array of frame identifiers with manifest urls for each frame containing a document
   * associated with some application cache.
   */
  @Returns("frameIds")
  @ReturnTypeParameter(FrameWithManifest.class)
  List<FrameWithManifest> getFramesWithManifests();

  /**
   * Returns manifest URL for document in the given frame.
   *
   * @param frameId Identifier of the frame containing document whose manifest is retrieved.
   */
  @Returns("manifestURL")
  String getManifestForFrame(@ParamName("frameId") String frameId);

  @EventName("applicationCacheStatusUpdated")
  EventListener onApplicationCacheStatusUpdated(
      EventHandler<ApplicationCacheStatusUpdated> eventListener);

  @EventName("networkStateUpdated")
  EventListener onNetworkStateUpdated(EventHandler<NetworkStateUpdated> eventListener);
}
