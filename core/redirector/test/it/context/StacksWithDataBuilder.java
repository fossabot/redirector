/**
 * Copyright 2017 Comcast Cable Communications Management, LLC
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * @author Stanislav Menshykov (smenshykov@productengine.com)
 */

package it.context;

public interface StacksWithDataBuilder extends ContextBuilderMain {
    StacksWithDataBuilder stack(String stack);
    StacksWithDataBuilder flavor(String flavor);
    StacksWithDataBuilder app(String app);
    StacksWithDataBuilder currentApp();
    StacksWithDataBuilder data(String data);
}
