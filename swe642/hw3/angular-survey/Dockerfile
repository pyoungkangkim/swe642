FROM node:latest
WORKDIR /app
ENV PATH /app/node_modules/.bin:$PATH
COPY package.json /app/package.json
RUN npm install
RUN npm install -g @angular/cli@11.2.0
COPY . /app
EXPOSE 4200
CMD ng serve --host 0.0.0.0 --disable-host-check
