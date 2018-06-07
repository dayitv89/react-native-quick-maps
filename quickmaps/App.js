/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */

import React, { Component } from 'react';
import { Platform, StyleSheet, Text, View } from 'react-native';

import BaseCustomView from './components/BaseCustomView';

export default class App extends Component {
	render() {
		return (
			<View style={styles.container}>
				<BaseCustomView text="Hello World" ref={o => (this.base = o)} style={styles.instructions} />
			</View>
		);
	}
}

const styles = StyleSheet.create({
	container: {
		flex: 1,
		justifyContent: 'center',
		alignItems: 'center',
		backgroundColor: '#fff087',
		padding: 20
	},
	welcome: {
		fontSize: 20,
		textAlign: 'center',
		margin: 10
	},
	instructions: {
		marginBottom: 5,
		height: '100%',
		width: '100%'
	}
});
