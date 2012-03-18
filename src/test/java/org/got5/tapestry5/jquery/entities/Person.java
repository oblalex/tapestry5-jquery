//
// Copyright 2010 GOT5 (GO Tapestry 5)
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// 	http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//

package org.got5.tapestry5.jquery.entities;

import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry5.beaneditor.NonVisual;

public class Person
{
    @NonVisual
    private long id;

    private List<Phone> phones = new ArrayList<Phone>();

    public List<Phone> getPhones()
    {
	return phones;
    }

    public void setPhones(List<Phone> phones)
    {
	this.phones = phones;
    }
}