import React, { Component } from 'react';
import { View, requireNativeComponent } from 'react-native';

import PropTypes from 'prop-types';

export default class QuickMapView extends Component {
	render() {
		return <R2RBaseCustomView {...this.props} />;
	}
}

BaseCustomView.propTypes = {
	myLocationEnable: PropTypes.bool,
	...View.propTypes
};

const R2RBaseCustomView = requireNativeComponent('R2RBaseCustomView', BaseCustomView);
