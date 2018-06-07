/**
 * Copyright (c) 2015-present, Facebook, Inc.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 *
 * @providesModule TouchThroughScrollView
 * @flow
 */
import React, { Component } from 'react';
import { View, requireNativeComponent } from 'react-native';

import PropTypes from 'prop-types';

export default class BaseCustomView extends Component {
	render() {
		return <R2RBaseCustomView {...this.props} />;
	}
}

BaseCustomView.propTypes = {
	text: PropTypes.string,
	...View.propTypes
};

const R2RBaseCustomView = requireNativeComponent('R2RBaseCustomView', BaseCustomView);
